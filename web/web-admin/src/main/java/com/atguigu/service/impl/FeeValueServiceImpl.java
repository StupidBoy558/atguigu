package com.atguigu.service.impl;

import com.atguigu.params.fees.FeeValueSaveOrUpdateParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.FeeValue;
import com.atguigu.service.FeeValueService;
import com.atguigu.mapper.FeeValueMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author wf_wj
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class FeeValueServiceImpl extends ServiceImpl<FeeValueMapper, FeeValue>
    implements FeeValueService{

    /**
     * 保存或更新杂费值.
     * @param params 杂费值保存或更新参数
     * @return 是否成功
     */
    @Override
    public Boolean saveOrUpdateFeeValue(FeeValueSaveOrUpdateParams params) {

        // 将请求体params转换为实体类对象
        FeeValue feeValue = FeeValueSaveOrUpdateParams.convertToEntity(params);

        // 根据params中的id值是否为空判断为新增或修改
        if (params.getId() == null) {
            // 新增
            feeValue.setCreateTime(new Date());
            feeValue.setIsDeleted(0);
            return this.save(feeValue);
        } else {
            // 修改
            LambdaQueryWrapper<FeeValue> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(FeeValue::getId, params.getId());
            FeeValue feeValueOld = this.getOne(queryWrapper);

            if (feeValueOld == null) {
                return false;
            }
            // 设置更新属性
            BeanUtils.copyProperties(feeValue, feeValueOld);
            feeValueOld.setUpdateTime(new Date());
            return this.updateById(feeValueOld);
        }

    }
}




