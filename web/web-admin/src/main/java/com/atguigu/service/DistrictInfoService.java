package com.atguigu.service;

import com.atguigu.entity.DistrictInfo;
import com.atguigu.params.regionInfo.DistrictInfoListParams;
import com.atguigu.vo.regionInfo.DistrictInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
 * @description: 针对表【district_info】的数据库操作Service
 * @createDate: 2024-09-16 22:26:48
*/
public interface DistrictInfoService extends IService<DistrictInfo> {

    /**
     * 根据城市id查询区县信息列表.
     *
     * @param params DistrictInfoListParams
     * @return List<DistrictInfo>
     */
    List<DistrictInfoVo> listDistrictInfo(DistrictInfoListParams params);
}
