package com.atguigu.service.impl;

import com.atguigu.entity.PaymentType;
import com.atguigu.mapper.PaymentTypeMapper;
import com.atguigu.params.paymentType.*;
import com.atguigu.service.PaymentTypeService;
import com.atguigu.vo.paymentType.PaymentTypeListVo;
import com.atguigu.vo.paymentType.PaymentTypeSearchVo;
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
    public List<PaymentTypeListVo> listPaymentType() {

        // 1. 查询所有支付方式
        LambdaQueryWrapper<PaymentType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PaymentType::getIsDeleted, 0);
        List<PaymentType> paymentTypes = paymentTypeMapper.selectList(queryWrapper);

        // 2. 转换为Vo

        return paymentTypes.stream()
            .map(paymentType -> {
                PaymentTypeListVo paymentTypeListVo = new PaymentTypeListVo();
                BeanUtils.copyProperties(paymentType, paymentTypeListVo);
                return paymentTypeListVo;
            })
            .collect(Collectors.toList());

    }

    @Override
    public Boolean saveOrUpdatePaymentType(PaymentTypeSaveOrUpdateParam param) {

        PaymentType paymentType = new PaymentType();

        // 2. 判断是新增还是修改
        if (param.getId() == null) {
            // 新增
            BeanUtils.copyProperties(param, paymentType);
            paymentType.setIsDeleted((byte) 0);
            paymentType.setCreateTime(new Date());
            return this.save(paymentType);
        } else {
            // 修改
            BeanUtils.copyProperties(param, paymentType);
            paymentType.setUpdateTime(new Date());
            return this.updateById(paymentType);
        }

    }

    @Override
    public Boolean savePaymentType(PaymentTypeSaveParams param) {

        // 1. 将param转为实体
        PaymentType paymentType = new PaymentType();
        BeanUtils.copyProperties(param, paymentType);

        // 2. 保存
        paymentType.setIsDeleted((byte) 0);
        paymentType.setCreateTime(new Date());

        return this.save(paymentType);
    }

    @Override
    public Boolean updatePaymentType(PaymentTypeUpdateParams param) {

        // 1. 将param转为实体
        PaymentType paymentType = new PaymentType();
        BeanUtils.copyProperties(param, paymentType);

        // 2. 更新
        paymentType.setUpdateTime(new Date());
        return this.updateById(paymentType);

    }

    @Override
    public Boolean deletePaymentById(PaymentTypeDeleteParams param) {

        // 如果id为空，返回false
        if (param.getId() == null) {
            return false;
        }

        // 删除
        return this.removeById(param.getId());
    }

    @Override
    public PaymentTypeSearchVo getPaymentTypeById(PaymentTypeSearchParams param) {

        // 如果id为空，返回null
        if (param.getId() == null) {
            return null;
        }

        // 查询
        LambdaQueryWrapper<PaymentType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PaymentType::getId, param.getId()).eq(PaymentType::getIsDeleted, 0);
        PaymentType paymentType = this.getOne(queryWrapper);

        if (paymentType != null) {
            PaymentTypeSearchVo paymentTypeSearchVo = new PaymentTypeSearchVo();
            BeanUtils.copyProperties(paymentType, paymentTypeSearchVo);
            return paymentTypeSearchVo;
        }

        return null;
    }
}




