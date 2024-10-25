package com.atguigu.service.impl;

import com.atguigu.enums.ItemType;
import com.atguigu.pojo.vo.graph.GraphVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.GraphInfo;
import com.atguigu.service.GraphInfoService;
import com.atguigu.mapper.GraphInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【graph_info(图片信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:34
 */
@Service
@RequiredArgsConstructor
public class GraphInfoServiceImpl extends ServiceImpl<GraphInfoMapper, GraphInfo>
        implements GraphInfoService {

    private final GraphInfoMapper graphInfoMapper;

    @Override
    public List<GraphVo> getGraphVoListByItemId(Long id, ItemType itemType) {

        return graphInfoMapper.getGraphVoListByItemId(id, itemType);
    }
}




