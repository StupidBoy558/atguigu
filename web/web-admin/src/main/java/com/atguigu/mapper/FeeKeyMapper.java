package com.atguigu.mapper;

import com.atguigu.entity.FeeKey;
import com.atguigu.vo.fees.FeeKeyListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author wf_wj
* @description: 针对表【fee_key(杂项费用名称表)】的数据库操作Mapper
* @createDate: 2024-09-16 22:26:48
* @Entity: com.atguigu.entity.FeeKey
*/
public interface FeeKeyMapper extends BaseMapper<FeeKey> {

    /**
     * 获取费用key列表.
     * @return 费用key列表.
     */
    List<FeeKeyListVo> feeInfoList();

}




