package com.atguigu.service.impl;

import com.atguigu.entity.PaymentType;
import com.atguigu.mapper.PaymentTypeMapper;
import com.atguigu.params.paymentType.PaymentTypeDeleteParam;
import com.atguigu.params.paymentType.PaymentTypeSaveOrUpdateParam;
import com.atguigu.params.paymentType.PaymentTypeSaveParam;
import com.atguigu.params.paymentType.PaymentTypeUpdateParam;
import com.atguigu.service.PaymentTypeService;
import com.atguigu.vo.paymentType.PaymentTypeVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author wf_wj
* @description 针对表【payment_type(支付方式表)】的数据库操作Service实现
* @createDate 2024-09-15 08:49:34
*/
@RequiredArgsConstructor
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService{

    private final PaymentTypeMapper paymentTypeMapper;

    @Override
    public List<PaymentTypeVo> listPaymentType() {

        // 1. 查询所有支付方式
        LambdaQueryWrapper<PaymentType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PaymentType::getIsDeleted, 0);
        List<PaymentType> paymentTypes = paymentTypeMapper.selectList(null);

        // 2. 转换为Vo

        return paymentTypes.stream()
            .map(paymentType -> {
                PaymentTypeVo paymentTypeVo = new PaymentTypeVo();
                BeanUtils.copyProperties(paymentType, paymentTypeVo);
                return paymentTypeVo;
            })
            .collect(Collectors.toList());

    }

    @Override
    public Boolean saveOrUpdatePaymentType(PaymentTypeSaveOrUpdateParam param) {

        // 1. 判断是新增还是修改
        PaymentType paymentType = new PaymentType();



        return null;
    }

    @Override
    public Boolean savePaymentType(PaymentTypeSaveParam param) {

        // 1. 将param转为实体
        PaymentType paymentType = new PaymentType();
        BeanUtils.copyProperties(param, paymentType);

        // 2. 保存
        paymentType.setIsDeleted((byte) 0);
        paymentType.setCreateTime(new Date());

        return this.save(paymentType);
    }

    @Override
    public Boolean updatePaymentType(PaymentTypeUpdateParam param) {

        // 1. 将param转为实体
        PaymentType paymentType = new PaymentType();
        BeanUtils.copyProperties(param, paymentType);

        // 2. 更新
        paymentType.setUpdateTime(new Date());
        return this.updateById(paymentType);

    }

    @Override
    public Boolean deletePaymentById(PaymentTypeDeleteParam param) {


        return null;
    }
}




