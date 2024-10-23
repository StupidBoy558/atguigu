package com.atguigu.mapper;

import com.atguigu.entity.FacilityInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【facility_info(配套信息表)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:34
 * @Entity com.atguigu.entity.FacilityInfo
 */
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    /**
     * 根据房间id获取配套信息.
     *
     * @param id 房间id
     * @return List<FacilityInfo> 配套信息列表
     */
    List<FacilityInfo> getFacilityInfoByRoomId(@Param("id") Long id);

    /**
     * 根据公寓id获取配套信息.
     *
     * @param id 公寓id
     * @return List<FacilityInfo> 配套信息列表
     */
    List<FacilityInfo> getFacilityInfoByAparmentId(@Param("id") Long id);
}




