package com.atguigu.service.impl;

import com.atguigu.entity.ApartmentFacility;
import com.atguigu.entity.ApartmentFeeValue;
import com.atguigu.entity.ApartmentInfo;
import com.atguigu.entity.ApartmentLabel;
import com.atguigu.entity.GraphInfo;
import com.atguigu.entity.RoomInfo;
import com.atguigu.enums.ItemType;
import com.atguigu.exception.LeaseException;
import com.atguigu.mapper.ApartmentInfoMapper;
import com.atguigu.mapper.FacilityInfoMapper;
import com.atguigu.mapper.FeeValueMapper;
import com.atguigu.mapper.GraphInfoMapper;
import com.atguigu.mapper.LabelInfoMapper;
import com.atguigu.mapper.RoomInfoMapper;
import com.atguigu.params.apartment.ApartmentDetailParams;
import com.atguigu.params.apartment.ApartmentInfoListParams;
import com.atguigu.params.apartment.ApartmentPageParams;
import com.atguigu.params.apartment.ApartmentRemoveParams;
import com.atguigu.params.apartment.ApartmentSaveParams;
import com.atguigu.params.apartment.ApartmentSearchParams;
import com.atguigu.params.apartment.ApartmentStatusUpdateParams;
import com.atguigu.params.apartment.ImageSaveParams;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.service.ApartmentFacilityService;
import com.atguigu.service.ApartmentFeeValueService;
import com.atguigu.service.ApartmentInfoService;
import com.atguigu.service.ApartmentLabelService;
import com.atguigu.service.GraphInfoService;
import com.atguigu.vo.BaseParams;
import com.atguigu.vo.BaseVo;
import com.atguigu.vo.apartment.ApartmentDetailVo;
import com.atguigu.vo.apartment.ApartmentInfoListVo;
import com.atguigu.vo.apartment.ApartmentItemVo;
import com.atguigu.vo.apartment.GraphVo;
import com.atguigu.vo.facilityInfo.FacilityInfoListVo;
import com.atguigu.vo.fees.FeeValueListVo;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    private final ApartmentFacilityService apartmentFacilityService;

    /**
     * 公寓标签服务.
     */
    private final ApartmentLabelService apartmentLabelService;

    /**
     * 公寓费用值服务.
     */
    private final ApartmentFeeValueService apartmentFeeService;

    /**
     * 图片信息服务.
     */
    private final GraphInfoService graphService;

    /**
     * 图片信息Mapper.
     */
    private final GraphInfoMapper graphInfoMapper;

    /**
     * 标签信息Mapper.
     */
    private final LabelInfoMapper labelInfoMapper;

    /**
     * 费用值Mapper.
     */
    private final FeeValueMapper feeValueMapper;

    /**
     * 配套设施Mapper.
     */
    private final FacilityInfoMapper facilityInfoMapper;

    /**
     * 房间信息Mapper.
     */
    private final RoomInfoMapper roomInfoMapper;

    /**
     * 保存或更新公寓信息.
     * @param params 公寓保存参数
     * @return 是否成功
     */
    @Override
    public String apartmentSaveOrUpdate(final ApartmentSaveParams params) {

        log.info("保存或更新公寓信息, params: {}", params);
        ApartmentInfo apartmentNew = ApartmentSaveParams.convertToEntity(params);
        // 是否更新
        Long paramsId = params.getId();
        boolean isUpdate = paramsId != null;
        super.saveOrUpdate(apartmentNew);

        //  更新操作：删除原有数据
        if (isUpdate) {
            // 删除图片列表
            removeApartmentRelations(paramsId);

            // 根据公寓ID新增配套关系
            List<ApartmentFacility> facilityList = ApartmentSaveParams.convertFacility(params);
            apartmentFacilityService.saveBatch(facilityList);
            // 根据公寓ID新增标签列表
            List<ApartmentLabel> labelList = ApartmentSaveParams.convertLabel(params);
            apartmentLabelService.saveBatch(labelList);
            // 根据公寓ID新增费用值列表
            List<ApartmentFeeValue> feeValueList = ApartmentSaveParams.convertFeeValue(params);
            apartmentFeeService.saveBatch(feeValueList);
            // 根据公寓id新增图片列表
            List<GraphInfo> graphList = ImageSaveParams.convert(params);
            graphService.saveBatch(graphList);

            return "更新成功";
        } else {
            // 新增操作
            Long apartmentNewId = apartmentNew.getId();

            // 根据公寓ID新增配套关系
            List<ApartmentFacility> facilityList = ApartmentSaveParams.convertFacility(params);
            if (!CollectionUtils.isEmpty(facilityList)) {
                facilityList.forEach(facility -> facility.setApartmentId(apartmentNewId));
                apartmentFacilityService.saveBatch(facilityList);
            }

            // 根据公寓ID新增标签列表
            List<ApartmentLabel> labelList = ApartmentSaveParams.convertLabel(params);
            if (!CollectionUtils.isEmpty(labelList)) {
                labelList.forEach(label -> label.setApartmentId(apartmentNewId));
                apartmentLabelService.saveBatch(labelList);
            }

            // 根据公寓ID新增费用值列表
            List<ApartmentFeeValue> feeValueList = ApartmentSaveParams.convertFeeValue(params);
            if (!CollectionUtils.isEmpty(feeValueList)) {
                feeValueList.forEach(feeValue -> feeValue.setApartmentId(apartmentNewId));
                apartmentFeeService.saveBatch(feeValueList);
            }

            // 根据公寓id新增图片列表
            List<GraphInfo> graphList = ImageSaveParams.convert(params);
            if (!CollectionUtils.isEmpty(graphList)) {
                graphList.forEach(graph -> graph.setItemId(apartmentNewId));
                graphService.saveBatch(graphList);
            }

            return "新增成功";
        }
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
            throw new IllegalArgumentException(
                    "Query parameters cannot be null");
        }
        return apartmentMapper.apartmentPageItem(page, queryParams);
    }

    /**
     * 根据ID值获取公寓信息.
     * @param params ApartmentDetailParams
     * @return 公寓详情
     */
    @Override
    public ApartmentDetailVo getDetailById(final ApartmentDetailParams params) {

        // 获取公寓ID
        Long apartmentId = params.getId();
        // 查询公寓信息
        ApartmentInfo apartmentInfo = this.getById(apartmentId);
        // 查询图片信息
        List<GraphVo> graphVoList =
                graphInfoMapper.selectListByIdAndItem(ItemType.APARTMENT, apartmentId);

        // 查询标签信息
        List<LabelInfoListVo> labelInfoListVo = labelInfoMapper.selectListById(apartmentId);

        // 查询配套信息
        List<FacilityInfoListVo> facilityInfoListVo =
                facilityInfoMapper.selectListByIdAndItem(ItemType.APARTMENT, apartmentId);

        // 查询费用值信息
        List<FeeValueListVo> feeValueListVo = feeValueMapper.selectFeeValueList(apartmentId);

        // 构造返回结果
        ApartmentDetailVo detailVo = ApartmentDetailVo.convertToVo(apartmentInfo);
        detailVo.setGraphVoList(graphVoList);
        detailVo.setLabelInfoList(labelInfoListVo);
        detailVo.setFacilityInfoList(facilityInfoListVo);
        detailVo.setFeeValueList(feeValueListVo);
        return detailVo;
    }

    /**
     * 根据ID删除公寓信息.
     *
     * @param params 删除参数
     */
    @Override
    public void removeApartmentById(final ApartmentRemoveParams params) {
        Long id = params.getId();

        // 判断公寓下是否还有房间
        LambdaQueryWrapper<RoomInfo> roomWrapper = new LambdaQueryWrapper<>();
        roomWrapper.eq(RoomInfo::getApartmentId, id);
        Long count = roomInfoMapper.selectCount(roomWrapper);

        if (count > 0) {
            throw new LeaseException(ResultCodeEnum.ADMIN_APARTMENT_DELETE_ERROR);
        }

        this.removeById(id);

        // 删除公寓信息的关系表数据
        removeApartmentRelations(id);
    }

    /**
     * 根据区县ID查询公寓信息列表.
     *
     * @param params ApartmentStatusUpdateParams
     * @return 是否成功
     */
    @Override
    public Boolean updateReleaseStatusById(final ApartmentStatusUpdateParams params) {

        LambdaUpdateWrapper<ApartmentInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ApartmentInfo::getId, params.getId());
        updateWrapper.set(ApartmentInfo::getIsRelease, params.getStatus());
        return this.update(updateWrapper);
    }

    @Override
    public List<ApartmentInfoListVo> listInfoByDistrictId(final ApartmentInfoListParams params) {
        LambdaQueryWrapper<ApartmentInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApartmentInfo::getDistrictId, params.getDistrictId());
        List<ApartmentInfo> apartmentInfoList = this.list(queryWrapper);
        return BaseVo.convertToVoList(apartmentInfoList, ApartmentInfoListVo.class);
    }

    /**
     * 删除公寓关联信息.
     *
     * @param paramsId 公寓ID
     */
    private void removeApartmentRelations(Long paramsId) {
        // 删除图片列表
        LambdaQueryWrapper<GraphInfo> graphWrapper = new LambdaQueryWrapper<>();
        graphWrapper.eq(GraphInfo::getItemType, ItemType.APARTMENT);
        graphWrapper.eq(GraphInfo::getItemId, paramsId);
        graphService.remove(graphWrapper);

        // 删除配套列表
        LambdaQueryWrapper<ApartmentFacility> facilityWrapper = new LambdaQueryWrapper<>();
        facilityWrapper.eq(ApartmentFacility::getApartmentId, paramsId);
        apartmentFacilityService.remove(facilityWrapper);

        // 删除标签列表
        LambdaQueryWrapper<ApartmentLabel> labelWrapper = new LambdaQueryWrapper<>();
        labelWrapper.eq(ApartmentLabel::getApartmentId, paramsId);
        apartmentLabelService.remove(labelWrapper);

        // 删除费用值列表
        LambdaQueryWrapper<ApartmentFeeValue> feeValueWrapper = new LambdaQueryWrapper<>();
        feeValueWrapper.eq(ApartmentFeeValue::getApartmentId, paramsId);
        apartmentFeeService.remove(feeValueWrapper);
    }
}





