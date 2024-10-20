package com.atguigu.service;


import com.atguigu.pojo.vo.user.LoginVo;
import com.atguigu.pojo.vo.user.UserInfoVo;

/**
 * @Description: 登录服务.
 * @Author: dansheng
 * @CreateTime: 2024/10/19 22:23
 **/
public interface LoginService {

    /**
     * 获取短信验证码.
     *
     * @param phone 手机号
     */
    void getSMSCode(String phone);

    /**
     * 登录.
     *
     * @param loginVo 登录信息
     * @return token
     */
    String login(LoginVo loginVo);

    /**
     * 获取用户信息.
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    UserInfoVo getUserInfoById(Long userId);
}
