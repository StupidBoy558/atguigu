package com.atguigu.service;

import com.atguigu.entity.AttrKey;
import com.atguigu.params.attribute.AttrKeyDeleteParams;
import com.atguigu.params.attribute.AttrKeySaveOrUpdateParams;
import com.atguigu.vo.attribute.AttrKeyListVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Service
* @createDate 2024-09-16 22:26:49
*/
public interface AttrKeyService extends IService<AttrKey> {

    /**
     * 保存或更新属性key.
     * @param params 保存或更新属性key请求参数
     * @return 保存或更新属性key结果
     */
    Boolean saveOrUpdateAttrKey(AttrKeySaveOrUpdateParams params);

    /**
     * 查询属性key列表.
     * @return 属性key列表
     */
    List<AttrKeyListVo> listAttrInfo();

    /**
     * 根据key的id删除属性key.同时删除对应的value
     *
     * @param params 删除属性key请求参数
     * @return 删除属性key结果
     */
    Boolean removeAttrKeyById(AttrKeyDeleteParams params);
}
