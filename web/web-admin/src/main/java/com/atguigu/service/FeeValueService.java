package com.atguigu.service;

import com.atguigu.entity.FeeValue;
import com.atguigu.params.fees.FeeValueSaveOrUpdateParams;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wf_wj
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Service
* @createDate 2024-09-16 22:26:48
*/
public interface FeeValueService extends IService<FeeValue> {

    /**
     * 保存或更新杂费值
     * @param params 杂费值保存或更新参数
     * @return 是否成功
     */
    Boolean saveOrUpdateFeeValue(FeeValueSaveOrUpdateParams params);
}
