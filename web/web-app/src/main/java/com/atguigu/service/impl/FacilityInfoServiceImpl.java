package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.FacilityInfo;
import com.atguigu.service.FacilityInfoService;
import com.atguigu.mapper.FacilityInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【facility_info(配套信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:34
 */
@Service
@RequiredArgsConstructor
public class FacilityInfoServiceImpl extends ServiceImpl<FacilityInfoMapper, FacilityInfo>
        implements FacilityInfoService {

    private final FacilityInfoMapper facilityInfoMapper;

    @Override
    public List<FacilityInfo> getFacilityInfoByRoomId(Long id) {

        return facilityInfoMapper.getFacilityInfoByRoomId(id);
    }

    @Override
    public List<FacilityInfo> getFacilityInfoByApartmentId(Long id) {

        return facilityInfoMapper.getFacilityInfoByAparmentId(id);
    }
}




