package com.atguigu.service;

import com.atguigu.entity.CityInfo;
import com.atguigu.params.regionInfo.CityInfoListParams;
import com.atguigu.vo.regionInfo.CityInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【city_info】的数据库操作Service
* @createDate 2024-09-16 22:26:48
*/
public interface CityInfoService extends IService<CityInfo> {

    /**
     * 根据省份id查询城市信息列表.
     *
     * @param params CityInfoListParams
     * @return List<CityInfo>
     */
    List<CityInfoVo> listCityInfo(CityInfoListParams params);
}
