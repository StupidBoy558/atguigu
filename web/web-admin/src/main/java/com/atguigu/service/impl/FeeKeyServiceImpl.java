package com.atguigu.service.impl;

import com.atguigu.entity.FeeValue;
import com.atguigu.params.fees.FeeKeyDeleteParams;
import com.atguigu.params.fees.FeeKeySaveOrUpdateParams;
import com.atguigu.service.FeeValueService;
import com.atguigu.vo.fees.FeeKeyListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.FeeKey;
import com.atguigu.service.FeeKeyService;
import com.atguigu.mapper.FeeKeyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author wf_wj
* @description: 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
* @createDate: 2024-09-16 22:26:48
*/
@Slf4j
@Service
@RequiredArgsConstructor
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService {

    /**
     * 费用keyMapper.
     */
    private final FeeKeyMapper feeKeyMapper;

    /**
     * 费用valueMapper.
     */
    private final FeeValueService feeValueService;

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
            LambdaQueryWrapper<FeeKey> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(FeeKey::getId, params.getId());
            FeeKey feeKeyOld = this.getOne(wrapper);

            if (feeKeyOld == null) {
                return false;
            }

            BeanUtils.copyProperties(entity, feeKeyOld);
            feeKeyOld.setUpdateTime(new Date());
            return this.updateById(feeKeyOld);

        }

    }

    /**
     * 获取费用key列表.
     * @return 费用key列表.
     */
    @Override
    public List<FeeKeyListVo> feeInfoList() {

        log.info("feeInfoList: ");
        return feeKeyMapper.feeInfoList();
    }

    /**
     * 删除费用key.
     * @param params 删除费用key请求体
     * @return 是否成功.
     */
    @Override
    public Boolean deleteFeeKeyById(final FeeKeyDeleteParams params) {

        // 根据id删除key
        boolean keyResult = this.removeById(params.getId());

        // 根据id值删除对应的value属性
        LambdaQueryWrapper<FeeValue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(FeeValue::getFeeKeyId, params.getId());
        boolean valueResult = feeValueService.remove(queryWrapper);

        return keyResult && valueResult;
    }
}




