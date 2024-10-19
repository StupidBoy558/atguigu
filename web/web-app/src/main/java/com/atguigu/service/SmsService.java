package com.atguigu.service;

public interface SmsService {

    /**
     * 发送验证码.
     *
     * @param phone
     * @param verifyCode
     */
    void sendCode(String phone, String verifyCode);
}
