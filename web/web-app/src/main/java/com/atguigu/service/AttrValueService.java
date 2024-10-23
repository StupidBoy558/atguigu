package com.atguigu.service;

import com.atguigu.entity.AttrValue;
import com.atguigu.pojo.vo.attr.AttrValueVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【attr_value(房间基本属性值表)】的数据库操作Service
 * @createDate 2024-10-19 09:50:34
 */
public interface AttrValueService extends IService<AttrValue> {

    /**
     * 根据房间id获取房间基本属性值列表.
     *
     * @param id 房间id
     * @return List<AttrValueVo> 房间基本属性值列表
     */
    List<AttrValueVo> getAttrValueVoByRoomId(Long id);
}
