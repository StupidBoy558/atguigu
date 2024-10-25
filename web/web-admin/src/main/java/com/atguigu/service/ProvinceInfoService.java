package com.atguigu.service;

import com.atguigu.entity.ProvinceInfo;
import com.atguigu.vo.regionInfo.ProvinceInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【province_info】的数据库操作Service
* @createDate 2024-09-16 22:26:49
*/
public interface ProvinceInfoService extends IService<ProvinceInfo> {

    /**
     * 查询省份信息列表.
     *
     * @return 省份信息列表VO
     */
    List<ProvinceInfoVo> listProvince();
}
