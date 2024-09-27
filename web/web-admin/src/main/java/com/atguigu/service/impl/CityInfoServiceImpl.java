package com.atguigu.service.impl;

import com.atguigu.params.regionInfo.CityInfoListParams;
import com.atguigu.vo.regionInfo.CityInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.CityInfo;
import com.atguigu.service.CityInfoService;
import com.atguigu.mapper.CityInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wf_wj
 * @description: 针对表【city_info】的数据库操作Service实现
 * @createDate: 2024-09-16 22:26:48
*/
@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
        implements CityInfoService {

    /**
     * 根据省份id查询城市信息列表.
     *
     * @param params CityInfoListParams
     * @return List<CityInfo>
     */
    @Override
    public List<CityInfoVo> listCityInfo(final CityInfoListParams params) {

        LambdaQueryWrapper<CityInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CityInfo::getProvinceId, params.getProvinceId());
        List<CityInfo> cityInfoList = this.list(queryWrapper);
        // 为空则返回null
        if (cityInfoList == null || cityInfoList.isEmpty()) {
            return null;
        }
        return CityInfoVo.convertToVo(cityInfoList);

    }
}




