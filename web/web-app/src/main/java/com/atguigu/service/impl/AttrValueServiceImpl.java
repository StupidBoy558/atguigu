package com.atguigu.service.impl;

import com.atguigu.pojo.vo.attr.AttrValueVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.AttrValue;
import com.atguigu.service.AttrValueService;
import com.atguigu.mapper.AttrValueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【attr_value(房间基本属性值表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:34
 */
@Service
@RequiredArgsConstructor
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue>
        implements AttrValueService {

    private final AttrValueMapper attrValueMapper;

    @Override
    public List<AttrValueVo> getAttrValueVoByRoomId(Long id) {
        return attrValueMapper.getAttrValueVoByRoomId(id);
    }
}




