package com.atguigu.utils;

import java.util.Random;

/**
 * @Description: 验证码工具类.
 * @Author: dansheng
 * @CreateTime: 2024/10/20 0:05
 **/
public class VerifyCodeUtil {

    public static String getVerifyCode(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

}
