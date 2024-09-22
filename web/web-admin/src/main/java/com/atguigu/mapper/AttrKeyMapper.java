package com.atguigu.mapper;

import com.atguigu.entity.AttrKey;
import com.atguigu.vo.attribute.AttrKeyListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author wf_wj
* @description: 针对表【attr_key(房间基本属性表)】的数据库操作Mapper
* @createDate: 2024-09-16 22:26:49
* @Entity: com.atguigu.entity.AttrKey
*/
public interface AttrKeyMapper extends BaseMapper<AttrKey> {

    /**
     * 查询属性key列表.
     * @return 属性key列表
     */
    List<AttrKeyListVo> listAttrInfo();
}





