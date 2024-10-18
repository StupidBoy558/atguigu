package com.atguigu.service.impl;

import com.atguigu.config.RedisConfig;
import com.atguigu.entity.SystemUser;
import com.atguigu.enums.BaseStatus;
import com.atguigu.exception.LeaseException;
import com.atguigu.mapper.SystemUserMapper;
import com.atguigu.params.login.LoginParams;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.service.LoginService;
import com.atguigu.utils.JwtUtil;
import com.atguigu.vo.login.CaptchaVo;
import com.atguigu.vo.system.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 后台管理系统登录管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/15
 **/
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    /**
     * Redis操作模板.
     */
    private final StringRedisTemplate redisTemplate;

    private final SystemUserMapper systemUserMapper;

    /**
     * 获取验证码.
     *
     * @return 验证码信息
     */
    @Override
    public CaptchaVo getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        specCaptcha.setCharType(Captcha.TYPE_DEFAULT);

        String code = specCaptcha.text().toLowerCase();
        String key = RedisConfig.ADMIN_LOGIN_PREFIX + UUID.randomUUID();
        String image = specCaptcha.toBase64();
        redisTemplate.opsForValue().set(key, code, RedisConfig.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);

        return new CaptchaVo(image, key);
    }

    /**
     * 登录.
     *
     * @param params 登录参数
     * @return token
     */
    @Override
    public String login(LoginParams params) {

        //1.判断是否输入了验证码
        if (!StringUtils.hasText(params.getCaptchaCode())) {
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }

        //2.校验验证码
        String code = redisTemplate.opsForValue().get(params.getCaptchaKey());
        if (code == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }

        if (!code.equals(params.getCaptchaCode().toLowerCase())) {
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }

        //3.校验用户是否存在
        SystemUser systemUser = systemUserMapper.selectOneByUsername(params.getUsername());

        if (systemUser == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }

        //4.校验用户是否被禁
        if (systemUser.getStatus().equals(BaseStatus.DISABLE)) {
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }

        //5.校验用户密码
        if (!systemUser.getPassword().equals(DigestUtils.md5Hex(params.getPassword()))) {
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }

        //6.创建并返回TOKEN
        return JwtUtil.createToken(systemUser.getId(), systemUser.getUsername());
    }

    @Override
    public SystemUserInfoVo getLoginUserInfo(final Long userId) {
        SystemUser systemUser = systemUserMapper.selectById(userId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        systemUserInfoVo.setName(systemUser.getName());
        systemUserInfoVo.setAvatarUrl(systemUser.getAvatarUrl());
        return systemUserInfoVo;
    }
}
