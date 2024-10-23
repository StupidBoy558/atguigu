package com.atguigu.mapper;

import com.atguigu.entity.GraphInfo;
import com.atguigu.enums.ItemType;
import com.atguigu.pojo.vo.graph.GraphVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:34
 * @Entity com.atguigu.entity.GraphInfo
 */
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    /**
     * 根据项目id和项目类型获取图片信息列表.
     *
     * @param id       项目id
     * @param itemType 项目类型
     * @return List<GraphVo> 图片信息列表
     */
    List<GraphVo> getGraphVoListByItemId(@Param("id") Long id, @Param("itemType") ItemType itemType);

}




