package com.atguigu.service;

import com.atguigu.entity.PaymentType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【payment_type(支付方式表)】的数据库操作Service
 * @createDate 2024-10-19 09:50:35
 */
public interface PaymentTypeService extends IService<PaymentType> {

    /**
     * 根据房间id获取支付方式列表.
     *
     * @param id 房间id
     * @return List<PaymentType> 支付方式列表
     */
    List<PaymentType> getPaymentTypeByRoomId(Long id);
}
