package com.atguigu.service;

import com.atguigu.entity.FacilityInfo;
import com.atguigu.params.facilityInfo.FacilityInfoListParams;
import com.atguigu.params.facilityInfo.FacilityInfoPageParams;
import com.atguigu.params.facilityInfo.FacilityInfoParams;
import com.atguigu.vo.facilityInfo.FacilityInfoListVo;
import com.atguigu.vo.facilityInfo.FacilityInfoPageVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
* @description: 针对表【facility_info(配套信息表)】的数据库操作Service
* @createDate: 2024-09-16 22:26:48
*/
public interface FacilityInfoService extends IService<FacilityInfo> {

    /**
     * 获取设施列表.
     *
     * @param param 设施信息列表参数类
     * @return 设施信息列表
     */
    List<FacilityInfoListVo> listFacility(FacilityInfoListParams param);

    /**
     * 分页获取设施列表.
     *
     * @param param 设施信息列表参数类
     * @return 设施信息列表
     */
    Page<FacilityInfoPageVo> pageFacility(FacilityInfoPageParams param);

    /**
     * 保存或更新设施信息.
     * @param param 保存或更新请求体
     * @return 是否成功
     */
    Boolean saveOrUpdateFacility(FacilityInfoParams param);
}
