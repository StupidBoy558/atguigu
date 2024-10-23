package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.PaymentType;
import com.atguigu.service.PaymentTypeService;
import com.atguigu.mapper.PaymentTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【payment_type(支付方式表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:35
 */
@Service
@RequiredArgsConstructor
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
        implements PaymentTypeService {

    private final PaymentTypeMapper paymentTypeMapper;

    @Override
    public List<PaymentType> getPaymentTypeByRoomId(Long id) {

        return paymentTypeMapper.getPaymentTypeByRoomId(id);
    }
}




