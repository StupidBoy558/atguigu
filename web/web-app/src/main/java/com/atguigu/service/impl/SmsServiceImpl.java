package com.atguigu.service.impl;


import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.atguigu.service.SmsService;
import com.atguigu.sms.AliyunSMSConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final AliyunSMSConfiguration smsConfiguration;

    @Override
    public void sendCode(String phone, String code) {

        SendSmsRequest smsRequest = new SendSmsRequest();
        smsRequest.setPhoneNumbers(phone);
        smsRequest.setSignName("阿里云短信测试");
        smsRequest.setTemplateCode("SMS_154950909");
        smsRequest.setTemplateParam("{\"code\":\"" + code + "\"}");
        try {
            smsConfiguration.smsClient().sendSms(smsRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
