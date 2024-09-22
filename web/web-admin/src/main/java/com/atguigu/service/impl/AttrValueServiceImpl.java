package com.atguigu.service.impl;

import com.atguigu.params.attribute.AttrValueSaveOrUpdateParams;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.AttrValue;
import com.atguigu.service.AttrValueService;
import com.atguigu.mapper.AttrValueMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.util.Date;

/**
* @author wf_wj
* @description: 针对表【attr_value(房间基本属性值表)】的数据库操作Service实现
* @createDate: 2024-09-16 22:26:48
*/
@Service
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue>
    implements AttrValueService {

    /**
     * 保存或更新属性值.
     * @param params 保存或更新属性值请求参数
     * @return 保存或更新属性值结果
     */
    @Override
    public Boolean saveOrUpdateAttrValue(
            final AttrValueSaveOrUpdateParams params) {
        // 根据id是否为空，判断是新增还是更新
        AttrValue attrValue = AttrValueSaveOrUpdateParams.convertToEntity(params);
        if (attrValue.getId() == null) {
            // 新增
            attrValue.setCreateTime(new Date());
            attrValue.setIsDeleted(0);
            return this.save(attrValue);
        } else {
            // 更新
            AttrValue attrValueOld = this.getById(attrValue.getId());
            if (attrValueOld == null) {
                log.error("属性值更新失败，未找到id为%s的记录" + attrValue.getId());
                return false;
            } else {
                BeanUtils.copyProperties(
                        attrValue, attrValueOld, "id", "createTime", "isDeleted");
                attrValueOld.setUpdateTime(new Date());
                return this.updateById(attrValueOld);
            }
        }

    }
}




