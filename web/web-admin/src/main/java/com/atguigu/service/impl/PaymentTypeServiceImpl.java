package com.atguigu.service.impl;

import com.atguigu.entity.PaymentType;
import com.atguigu.mapper.PaymentTypeMapper;
import com.atguigu.service.PaymentTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【payment_type(支付方式表)】的数据库操作Service实现
* @createDate 2024-09-15 08:49:34
*/
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService{

}




