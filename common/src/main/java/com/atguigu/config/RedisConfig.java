package com.atguigu.config;

import org.springframework.stereotype.Component;

/**
 * @Description: Redis配置.
 * @Author: dansheng
 * @CreateTime: 2024/10/15
 **/
@Component
public class RedisConfig {

    public static final String ADMIN_LOGIN_PREFIX = "admin:login:";
    public static final Integer ADMIN_LOGIN_CAPTCHA_TTL_SEC = 60;
    public static final String APP_LOGIN_PREFIX = "app:login:";
    public static final Integer APP_LOGIN_CODE_RESEND_TIME_SEC = 60;
    public static final Integer APP_LOGIN_CODE_TTL_SEC = 60 * 10;
    public static final String APP_ROOM_PREFIX = "app:room:";
}
