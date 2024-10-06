package com.atguigu.service.impl;

import com.atguigu.entity.ApartmentFacility;
import com.atguigu.entity.ApartmentFeeValue;
import com.atguigu.entity.ApartmentInfo;
import com.atguigu.entity.ApartmentLabel;
import com.atguigu.entity.GraphInfo;
import com.atguigu.enums.ItemType;
import com.atguigu.mapper.ApartmentInfoMapper;
import com.atguigu.params.apartment.ApartmentPageParams;
import com.atguigu.params.apartment.ApartmentSaveParams;
import com.atguigu.params.apartment.ApartmentSearchParams;
import com.atguigu.params.apartment.ImageSaveParams;
import com.atguigu.service.ApartmentFacilityService;
import com.atguigu.service.ApartmentFeeValueService;
import com.atguigu.service.ApartmentInfoService;
import com.atguigu.service.ApartmentLabelService;
import com.atguigu.service.GraphInfoService;
import com.atguigu.vo.apartment.ApartmentItemVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wf_wj
 * @Description: 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate: 2024-09-16 22:26:48
*/
@Slf4j
@RequiredArgsConstructor
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl
        <ApartmentInfoMapper, ApartmentInfo> implements ApartmentInfoService {

    /**
     * 公寓信息Mapper.
     */
    private final ApartmentInfoMapper apartmentMapper;

    /**
     * 公寓配套服务.
     */
    private final ApartmentFacilityService facilityService;

    /**
     * 公寓标签服务.
     */
    private final ApartmentLabelService labelService;

    /**
     * 公寓费用值服务.
     */
    private final ApartmentFeeValueService feeValueService;

    /**
     * 图片信息服务.
     */
    private final GraphInfoService graphService;

    /**
     * 保存或更新公寓信息.
     * @param params 公寓保存参数
     * @return 是否成功
     */
    @Override
    public String apartmentSaveOrUpdate(final ApartmentSaveParams params) {

        log.info("保存或更新公寓信息, params: {}", params);
        ApartmentInfo apartmentNew =
                ApartmentSaveParams.convertToEntity(params);
        // 是否更新
        Long paramsId = params.getId();
        boolean isUpdate = paramsId != null;
        super.saveOrUpdate(apartmentNew);

        //  更新操作：删除原有数据
        if (isUpdate) {

            // 删除图片列表
            LambdaQueryWrapper<GraphInfo> graphWrapper
                    = new LambdaQueryWrapper<>();
            graphWrapper.eq(GraphInfo::getItemType, ItemType.APARTMENT);
            graphWrapper.eq(GraphInfo::getItemId, paramsId);
            graphService.remove(graphWrapper);
            // 删除配套列表
            LambdaQueryWrapper<ApartmentFacility> facilityWrapper
                    = new LambdaQueryWrapper<>();
            facilityWrapper.eq(ApartmentFacility::getApartmentId, paramsId);
            facilityService.remove(facilityWrapper);
            // 删除标签列表
            LambdaQueryWrapper<ApartmentLabel> labelWrapper
                    = new LambdaQueryWrapper<>();
            labelWrapper.eq(ApartmentLabel::getApartmentId, paramsId);
            labelService.remove(labelWrapper);
            // 删除费用值列表
            LambdaQueryWrapper<ApartmentFeeValue> feeValueWrapper
                    = new LambdaQueryWrapper<>();
            feeValueWrapper.eq(ApartmentFeeValue::getApartmentId, paramsId);
            feeValueService.remove(feeValueWrapper);

        }

        // 根据公寓ID新增配套关系
        List<ApartmentFacility> facilityList
                = ApartmentSaveParams.convertFacility(params);
        facilityService.saveBatch(facilityList);
        // 根据公寓ID新增标签列表
        List<ApartmentLabel> labelList
                = ApartmentSaveParams.convertLabel(params);
        labelService.saveBatch(labelList);
        // 根据公寓ID新增费用值列表
        List<ApartmentFeeValue> feeValueList
                = ApartmentSaveParams.convertFeeValue(params);
        feeValueService.saveBatch(feeValueList);
        // 根据公寓id新增图片列表
        List<GraphInfo> graphList = ImageSaveParams.convert(params);
        graphService.saveBatch(graphList);

        return "操作成功";

    }

    /**
     * 分页查询公寓信息.
     *
     * @param params 查询参数
     * @return 公寓信息列表
     */
    @Override
    public IPage<ApartmentItemVo> apartmentPageItem(
            final ApartmentPageParams params) {
        log.info("apartmentPageItem called with params: {}", params);
        Page<ApartmentItemVo> page =
                new Page<>(params.getCurrent(), params.getSize());
        ApartmentSearchParams queryParams = params.getQueryParams();
        if (queryParams == null) {
            throw new IllegalArgumentException("Query parameters cannot be null");
        }
        return apartmentMapper.apartmentPageItem(page, queryParams);
    }
}




