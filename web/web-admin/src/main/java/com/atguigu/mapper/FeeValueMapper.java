package com.atguigu.mapper;

import com.atguigu.entity.FeeValue;
import com.atguigu.vo.fees.FeeValueListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:48
* @Entity com.atguigu.entity.FeeValue
*/
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    /**
     * 查询杂项费用值列表.
     *
     * @param apartmentId 公寓ID
     * @return 杂项费用值列表
     */
    List<FeeValueListVo> selectFeeValueList(@Param("id") Long apartmentId);
}




