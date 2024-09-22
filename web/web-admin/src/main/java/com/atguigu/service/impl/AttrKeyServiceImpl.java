package com.atguigu.service.impl;

import com.atguigu.entity.AttrValue;
import com.atguigu.params.attribute.AttrKeyDeleteParams;
import com.atguigu.params.attribute.AttrKeySaveOrUpdateParams;
import com.atguigu.service.AttrValueService;
import com.atguigu.vo.attribute.AttrKeyListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.AttrKey;
import com.atguigu.service.AttrKeyService;
import com.atguigu.mapper.AttrKeyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author wf_wj
* @description: 针对表【attr_key(房间基本属性表)】的数据库操作Service实现
* @createDate: 2024-09-16 22:26:49
*/
@Service
@RequiredArgsConstructor
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey>
    implements AttrKeyService {

    /**
     * 房间的属性值管理服务.
     */
    private final AttrKeyMapper attrKeyMapper;

    /**
     * 房间的属性value管理接口service.
     */
    private final AttrValueService attrValueService;

    /**
     * 保存或更新属性key.
     * @param params 保存或更新属性key请求参数
     * @return
     */
    @Override
    public Boolean saveOrUpdateAttrKey(final AttrKeySaveOrUpdateParams params) {

        // 根据id值是否为空判断为新增或修改
        AttrKey attrKey = AttrKeySaveOrUpdateParams.convertToEntity(params);
        if (attrKey.getId() == null) {
            // 新增
            attrKey.setCreateTime(new Date());
            attrKey.setIsDeleted(0);
            return this.save(attrKey);
        } else {
            // 更新
            AttrKey attrKeyOld = this.getById(attrKey.getId());
            if (attrKeyOld != null) {
                BeanUtils.copyProperties(
                        attrKey, attrKeyOld, "id", "createTime", "isDeleted");
                attrKeyOld.setUpdateTime(new Date());
                return this.updateById(attrKeyOld);
            } else {
                log.error("属性key更新失败，未找到id为%s的记录" + attrKey.getId());
                return false;
            }
        }
    }

    /**
     * 查询属性key列表.
     * @return 属性key列表
     */
    @Override
    public List<AttrKeyListVo> listAttrInfo() {
        return attrKeyMapper.listAttrInfo();
    }

    /**
     * 根据key的id删除属性key.同时删除对应的value
     *
     * @param params 删除属性key请求参数
     * @return 删除属性key结果
     */
    @Override
    public Boolean removeAttrKeyById(AttrKeyDeleteParams params) {
        boolean removeKey = this.removeById(params.getId());
        LambdaQueryWrapper<AttrValue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AttrValue::getAttrKeyId, params.getId());
        boolean removeValue = attrValueService.remove(queryWrapper);
        return removeKey && removeValue;
    }
}




