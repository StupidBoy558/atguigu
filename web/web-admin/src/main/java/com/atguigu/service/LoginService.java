package com.atguigu.service;


import com.atguigu.params.login.LoginParams;
import com.atguigu.vo.login.CaptchaVo;
import com.atguigu.vo.system.SystemUserInfoVo;

/**
 * @Description: 后台管理系统登录管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/15
 **/

public interface LoginService {

    /**
     * 获取验证码.
     *
     * @return 验证码信息
     */
    CaptchaVo getCaptcha();

    /**
     * 登录.
     *
     * @param params 登录参数
     * @return token
     */
    String login(LoginParams params);

    /**
     * 获取登陆用户个人信息.
     *
     * @param userId 用户id
     * @return 用户信息
     */
    SystemUserInfoVo getLoginUserInfo(Long userId);
}
