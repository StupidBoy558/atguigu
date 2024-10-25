package com.atguigu.service.impl;

import com.atguigu.params.regionInfo.DistrictInfoListParams;
import com.atguigu.vo.regionInfo.DistrictInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.DistrictInfo;
import com.atguigu.service.DistrictInfoService;
import com.atguigu.mapper.DistrictInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【district_info】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class DistrictInfoServiceImpl extends ServiceImpl<DistrictInfoMapper, DistrictInfo>
    implements DistrictInfoService{

    /**
     * 根据城市id查询区县信息列表.
     *
     * @param params DistrictInfoListParams
     * @return List<DistrictInfo>
     */
    @Override
    public List<DistrictInfoVo> listDistrictInfo(DistrictInfoListParams params) {

        LambdaQueryWrapper<DistrictInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DistrictInfo::getCityId, params.getCityId());
        List<DistrictInfo> districtInfoList = this.list(queryWrapper);
        if (districtInfoList != null && !districtInfoList.isEmpty()) {
            return DistrictInfoVo.convertToVO(districtInfoList);
        }

        return null;
    }
}




