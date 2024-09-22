package com.atguigu.service;

import com.atguigu.entity.AttrValue;
import com.atguigu.params.attribute.AttrValueSaveOrUpdateParams;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wf_wj
* @description: 针对表【attr_value(房间基本属性值表)】的数据库操作Service
* @createDate: 2024-09-16 22:26:48
*/
public interface AttrValueService extends IService<AttrValue> {

    /**
     *  保存或更新属性值.
     * @param params 保存或更新属性值请求参数
     * @return 保存或更新属性值结果
     */
    Boolean saveOrUpdateAttrValue(AttrValueSaveOrUpdateParams params);
}
