package com.atguigu.service.impl;

import com.atguigu.config.RedisConstant;
import com.atguigu.entity.UserInfo;
import com.atguigu.enums.BaseStatus;
import com.atguigu.exception.LeaseException;
import com.atguigu.pojo.vo.user.LoginVo;
import com.atguigu.pojo.vo.user.UserInfoVo;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.service.LoginService;
import com.atguigu.service.SmsService;
import com.atguigu.utils.JwtUtil;
import com.atguigu.utils.VerifyCodeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.atguigu.service.UserInfoService;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 登录服务实现类.
 * @Author: dansheng
 * @CreateTime: 2024/10/19 22:24
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final RedisTemplate redisTemplate;

    private final SmsService smsService;

    private final UserInfoService userInfoService;

    @Override
    public void getSMSCode(String phone) {

        log.info("获取短信验证码，手机号：{}", phone);
        //1. 检查手机号码是否为空
        if (!StringUtils.hasText(phone)) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }

        //2. 检查Redis中是否已经存在该手机号码的key
        String key = RedisConstant.APP_LOGIN_PREFIX + phone;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            //若存在，则检查其存在的时间
            Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
            if (RedisConstant.APP_LOGIN_CODE_TTL_SEC - expire < RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC) {
                //若存在时间不足一分钟，响应发送过于频繁
                throw new LeaseException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
            }
        }

        //3.发送短信，并将验证码存入Redis
        String verifyCode = VerifyCodeUtil.getVerifyCode(6);
        smsService.sendCode(phone, verifyCode);
        redisTemplate.opsForValue().set(key, verifyCode, RedisConstant.APP_LOGIN_CODE_TTL_SEC, TimeUnit.SECONDS);


    }

    @Override
    public String login(LoginVo loginVo) {

        //1.判断手机号码和验证码是否为空
        if (!StringUtils.hasText(loginVo.getPhone())) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }

        if (!StringUtils.hasText(loginVo.getCode())) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EMPTY);
        }

        //2.校验验证码
        String key = RedisConstant.APP_LOGIN_PREFIX + loginVo.getPhone();
        String code = (String) redisTemplate.opsForValue().get(key);
        if (code == null) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EXPIRED);
        }

        if (!code.equals(loginVo.getCode())) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_ERROR);
        }

        //3.判断用户是否存在,不存在则注册（创建用户）
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getPhone, loginVo.getPhone());
        UserInfo userInfo = userInfoService.getOne(queryWrapper);
        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setPhone(loginVo.getPhone());
            userInfo.setStatus(BaseStatus.ENABLE.getCode());
            userInfo.setNickname("用户-" + loginVo.getPhone().substring(6));
            userInfoService.save(userInfo);
        }

        //4.判断用户是否被禁
        if (userInfo.getStatus().equals(BaseStatus.DISABLE)) {
            throw new LeaseException(ResultCodeEnum.APP_ACCOUNT_DISABLED_ERROR);
        }

        //5.创建并返回TOKEN
        return JwtUtil.createToken(userInfo.getId(), loginVo.getPhone());
    }

    @Override
    public UserInfoVo getUserInfoById(final Long userId) {

        UserInfo userInfo = userInfoService.getById(userId);
        if (userInfo != null) {
            return new UserInfoVo(userInfo.getNickname(), userInfo.getAvatarUrl());
        }
        throw new LeaseException(
                ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR.getCode(), "用户不存在");
    }
}
