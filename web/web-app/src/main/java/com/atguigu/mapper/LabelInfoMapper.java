package com.atguigu.mapper;

import com.atguigu.entity.LabelInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【label_info(标签信息表)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:34
 * @Entity com.atguigu.entity.LabelInfo
 */
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    /**
     * 根据房间id获取标签信息.
     *
     * @param id 房间id
     * @return List<LabelInfo> 标签信息
     */
    List<LabelInfo> getLabelInfoByRoomId(@Param("id") Long id);

    /**
     * 根据公寓id获取标签信息.
     *
     * @param id 公寓id
     * @return List<LabelInfo> 标签信息
     */
    List<LabelInfo> getLabelInfoByApartmentId(@Param("id") Long id);
}




