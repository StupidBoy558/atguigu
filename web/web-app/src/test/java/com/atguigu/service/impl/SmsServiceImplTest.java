package com.atguigu.service.impl;

import com.atguigu.service.SmsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SmsServiceImplTest {

    @Autowired
    private SmsService smsService;

    @Test
    void sendCode() {

        smsService.sendCode("19050566943", "123456");

    }
}