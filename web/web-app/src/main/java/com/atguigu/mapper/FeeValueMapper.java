package com.atguigu.mapper;

import com.atguigu.entity.FeeValue;
import com.atguigu.pojo.vo.fee.FeeValueVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【fee_value(杂项费用值表)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:34
 * @Entity com.atguigu.entity.FeeValue
 */
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    /**
     * 根据房间id获取杂项费用值列表.
     *
     * @param id 房间id
     * @return List<FeeValueVo> 杂项费用值列表
     */
    List<FeeValueVo> getFeeValueByApartmentId(@Param("id") Long id);
}




