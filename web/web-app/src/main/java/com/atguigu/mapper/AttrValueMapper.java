package com.atguigu.mapper;

import com.atguigu.entity.AttrValue;
import com.atguigu.pojo.vo.attr.AttrValueVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【attr_value(房间基本属性值表)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:34
 * @Entity com.atguigu.entity.AttrValue
 */
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    /**
     * 根据房间id获取房间基本属性值列表.
     *
     * @param id 房间id
     * @return List<AttrValueVo> 房间基本属性值列表
     */
    List<AttrValueVo> getAttrValueVoByRoomId(@Param("id") Long id);
}




