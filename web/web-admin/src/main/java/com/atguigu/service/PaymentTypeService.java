package com.atguigu.service;

import com.atguigu.entity.PaymentType;
import com.atguigu.params.paymentType.*;
import com.atguigu.vo.paymentType.PaymentTypeListVo;
import com.atguigu.vo.paymentType.PaymentTypeSearchVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【payment_type(支付方式表)】的数据库操作Service
* @createDate 2024-09-15 08:49:34
*/
public interface PaymentTypeService extends IService<PaymentType> {

    /**
     * 获取支付方式列表
     * @return
     */
    List<PaymentTypeListVo> listPaymentType();

    /**
     * 保存或更新支付方式
     * @param param
     */
    Boolean saveOrUpdatePaymentType(PaymentTypeSaveOrUpdateParam param);

    /**
     * 新增支付方式
     *
     * @param param
     * @return
     */
    Boolean savePaymentType(PaymentTypeSaveParams param);

    /**
     * 更新支付方式
     * @param param
     * @return
     */
    Boolean updatePaymentType(PaymentTypeUpdateParams param);

    /**
     * 删除支付方式
     * @param param
     * @return
     */
    Boolean deletePaymentById(PaymentTypeDeleteParams param);

    /**
     * 根据id获取支付方式
     * @param param
     * @return
     */
    PaymentTypeSearchVo getPaymentTypeById(PaymentTypeSearchParams param);
}
