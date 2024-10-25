package com.atguigu.mapper;

import com.atguigu.entity.GraphInfo;
import com.atguigu.enums.ItemType;
import com.atguigu.vo.apartment.GraphVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:48
* @Entity com.atguigu.entity.GraphInfo
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    /**
     * 根据ID和类型获取图片信息.
     *
     * @param itemType    图片类型
     * @param apartmentId 公寓ID
     * @return 图片信息
     */
    List<GraphVo> selectListByIdAndItem(
            @Param("itemType") ItemType itemType, @Param("id") Long apartmentId);
}




