package com.atguigu.service.impl;

import com.atguigu.params.fees.FeeKeySaveOrUpdateParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.FeeKey;
import com.atguigu.service.FeeKeyService;
import com.atguigu.mapper.FeeKeyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author wf_wj
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService{

    /**
     * 保存或更新费用key.
     * @param params 保存或更新杂费key.
     * @return 是否成功.
     */
    @Override
    public Boolean saveOrUpdateFeeKey(final FeeKeySaveOrUpdateParams params) {

        // 将params转换为实体
        FeeKey entity = FeeKeySaveOrUpdateParams.convertToEntity(params);

        // 根据params中id值是否为空判断为新增或修改
        if (params.getId() == null) {
            // 新增
            entity.setCreateTime(new Date());
            entity.setIsDeleted(0);
            return this.save(entity);
        } else {
            // 修改
            LambdaQueryWrapper<FeeKey> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(FeeKey::getId, params.getId());
            FeeKey feeKeyOld = this.getOne(queryWrapper);

            if (feeKeyOld == null) {
                return false;
            }

            BeanUtils.copyProperties(entity, feeKeyOld);
            feeKeyOld.setUpdateTime(new Date());
            return this.updateById(feeKeyOld);

        }

    }
}




