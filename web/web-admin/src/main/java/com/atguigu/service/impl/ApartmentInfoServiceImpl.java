package com.atguigu.service.impl;

import com.atguigu.entity.ApartmentFacility;
import com.atguigu.entity.FacilityInfo;
import com.atguigu.params.apartment.ApartmentSaveParams;
import com.atguigu.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.ApartmentInfo;
import com.atguigu.mapper.ApartmentInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author wf_wj
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Slf4j
@RequiredArgsConstructor
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
    implements ApartmentInfoService{

    private final ApartmentInfoMapper apartmentInfoMapper;

    private final FacilityInfoService facilityInfoService;

    /**
     * 保存或更新公寓信息.
     *
     * @param params 公寓保存参数
     * @return 是否成功
     */
    @Override
    public String apartmentSaveOrUpdate(ApartmentSaveParams params) {

        log.info("保存或更新公寓信息, params: {}", params);
        ApartmentInfo apartmentInfoNew =
                ApartmentSaveParams.convertToEntity(params);

        // 如果ID为空则新增, 否则更新
        if (params.getId() == null) {

            apartmentInfoNew.setCreateTime(new Date());
            this.save(apartmentInfoNew);

            Long infoNewId = apartmentInfoNew.getId();
            // 根据公寓ID新增配套关系
            LambdaQueryWrapper<ApartmentFacility> facilityWrapper = new LambdaQueryWrapper<>();

            return "新增成功";
        } else {
            apartmentInfoMapper.updateById(apartmentInfoNew);
            return "更新成功";
        }

    }
}




