package com.atguigu.mapper;

import com.atguigu.entity.AttrValue;
import com.atguigu.vo.attribute.AttrValueListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:48
* @Entity com.atguigu.entity.AttrValue
*/
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    /**
     * 根据房间id查询房间基本属性值列表.
     *
     * @param roomId 房间id
     * @return 房间基本属性值列表
     */
    List<AttrValueListVo> listByRoomId(@Param("id") Long roomId);
}




