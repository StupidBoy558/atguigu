package com.atguigu.service;

import com.atguigu.entity.FeeKey;
import com.atguigu.params.fees.FeeKeySaveOrUpdateParams;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wf_wj
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service
* @createDate 2024-09-16 22:26:48
*/
public interface FeeKeyService extends IService<FeeKey> {

    /**
     * 保存或更新费用key.
     * @param params 保存或更新杂费key.
     * @return 是否成功.
     */
    Boolean saveOrUpdateFeeKey(FeeKeySaveOrUpdateParams params);
}
