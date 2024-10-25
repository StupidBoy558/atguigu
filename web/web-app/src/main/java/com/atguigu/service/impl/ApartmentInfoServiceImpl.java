package com.atguigu.service.impl;

import com.atguigu.entity.FacilityInfo;
import com.atguigu.entity.LabelInfo;
import com.atguigu.enums.ItemType;
import com.atguigu.pojo.vo.apartment.ApartmentDetailVo;
import com.atguigu.pojo.vo.apartment.ApartmentItemVo;
import com.atguigu.pojo.vo.graph.GraphVo;
import com.atguigu.service.FacilityInfoService;
import com.atguigu.service.GraphInfoService;
import com.atguigu.service.LabelInfoService;
import com.atguigu.service.LeaseAgreementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.ApartmentInfo;
import com.atguigu.service.ApartmentInfoService;
import com.atguigu.mapper.ApartmentInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:34
 */
@Service
@RequiredArgsConstructor
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

    private final ApartmentInfoMapper apartmentInfoMapper;

    private final GraphInfoService graphInfoService;

    private final LabelInfoService labelInfoService;

    private final FacilityInfoService facilityInfoService;

    private final LeaseAgreementService leaseAgreementService;

    @Override
    public ApartmentItemVo getItemVoById(Long apartmentId) {

        return apartmentInfoMapper.getItemVoById(apartmentId);
    }

    @Override
    public ApartmentDetailVo getDetailById(Long id) {

        // 查询公寓基本信息
        ApartmentDetailVo apartmentDetailVo = apartmentInfoMapper.getDetailById(id);


        // 查询图片列表
        List<GraphVo> graphVoList = graphInfoService.getGraphVoListByItemId(id, ItemType.APARTMENT);

        // 查询标签列表
        List<LabelInfo> labelInfoList = labelInfoService.getLabelInfoByApartmentId(id);

        // 查询配套列表
        List<FacilityInfo> facilityInfoList = facilityInfoService.getFacilityInfoByApartmentId(id);

        // 查询租金最小值
        BigDecimal minRent = leaseAgreementService.getMinRentByApartmentId(id);

        apartmentDetailVo.setGraphVoList(graphVoList);
        apartmentDetailVo.setLabelInfoList(labelInfoList);
        apartmentDetailVo.setFacilityInfoList(facilityInfoList);
        apartmentDetailVo.setMinRent(minRent);

        return apartmentDetailVo;
    }
}




