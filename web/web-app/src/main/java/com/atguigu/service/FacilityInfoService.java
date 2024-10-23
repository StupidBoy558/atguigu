package com.atguigu.service;

import com.atguigu.entity.FacilityInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【facility_info(配套信息表)】的数据库操作Service
 * @createDate 2024-10-19 09:50:34
 */
public interface FacilityInfoService extends IService<FacilityInfo> {

    /**
     * 根据房间id获取配套信息.
     *
     * @param id 房间id
     * @return List<FacilityInfo> 配套信息列表
     */
    List<FacilityInfo> getFacilityInfoByRoomId(Long id);
}
