package com.atguigu.mapper;

import com.atguigu.entity.FacilityInfo;
import com.atguigu.enums.ItemType;
import com.atguigu.vo.facilityInfo.FacilityInfoListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【facility_info(配套信息表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:48
* @Entity com.atguigu.entity.FacilityInfo
*/
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    /**
     * 根据ID和类型查询配套信息.
     *
     * @param itemType    配套类型
     * @param apartmentId 公寓ID
     * @return
     */
    List<FacilityInfoListVo> selectListByIdAndItem(
            @Param("itemType") ItemType itemType, @Param("id") Long apartmentId);

    /**
     * 根据房间ID查询配套信息.
     *
     * @param roomId 房间ID
     * @return 配套信息列表
     */
    List<FacilityInfoListVo> listByRoomId(@Param("id") Long roomId);
}




