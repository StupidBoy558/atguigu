package com.atguigu.service;

import com.atguigu.entity.FeeValue;
import com.atguigu.pojo.vo.fee.FeeValueVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【fee_value(杂项费用值表)】的数据库操作Service
 * @createDate 2024-10-19 09:50:34
 */
public interface FeeValueService extends IService<FeeValue> {

    /**
     * 根据公寓id获取杂项费用值列表.
     *
     * @param id 公寓id
     * @return List<FeeValueVo> 杂项费用值列表
     */
    List<FeeValueVo> getFeeValueByApartmentId(Long id);
}
