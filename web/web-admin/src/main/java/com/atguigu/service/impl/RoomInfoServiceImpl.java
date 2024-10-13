package com.atguigu.service.impl;

import com.atguigu.entity.GraphInfo;
import com.atguigu.entity.RoomAttrValue;
import com.atguigu.entity.RoomFacility;
import com.atguigu.entity.RoomLabel;
import com.atguigu.entity.RoomLeaseTerm;
import com.atguigu.entity.RoomPaymentType;
import com.atguigu.enums.ItemType;
import com.atguigu.enums.ReleaseStatus;
import com.atguigu.mapper.AttrValueMapper;
import com.atguigu.mapper.FacilityInfoMapper;
import com.atguigu.mapper.LabelInfoMapper;
import com.atguigu.mapper.LeaseAgreementMapper;
import com.atguigu.mapper.PaymentTypeMapper;
import com.atguigu.params.room.RoomGetByIdParam;
import com.atguigu.params.room.RoomListByApartmentIdParam;
import com.atguigu.params.room.RoomPageItemParam;
import com.atguigu.params.room.RoomRemoveByIdParam;
import com.atguigu.params.room.RoomSaveOrUpdateParam;
import com.atguigu.params.room.RoomUpdateStatusByIdParam;
import com.atguigu.service.GraphInfoService;
import com.atguigu.service.RoomAttrValueService;
import com.atguigu.service.RoomFacilityService;
import com.atguigu.service.RoomLabelService;
import com.atguigu.service.RoomLeaseTermService;
import com.atguigu.service.RoomPaymentTypeService;
import com.atguigu.vo.BaseParams;
import com.atguigu.vo.BaseVo;
import com.atguigu.vo.apartment.GraphVo;
import com.atguigu.vo.attribute.AttrValueListVo;
import com.atguigu.vo.facilityInfo.FacilityInfoListVo;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import com.atguigu.vo.leaseTerm.LeaseTermListVo;
import com.atguigu.vo.paymentType.PaymentTypeListVo;
import com.atguigu.vo.room.RoomInfoItemVo;
import com.atguigu.vo.room.RoomInfoVo;
import com.atguigu.vo.room.RoomPageVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.RoomInfo;
import com.atguigu.service.RoomInfoService;
import com.atguigu.mapper.RoomInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: wf_wj
 * @description: 针对表【room_info(房间信息表)】的数据库操作Service实现
 * @createDate: 2024-09-16 22:26:48
*/
@Service
@Slf4j
@RequiredArgsConstructor
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    /**
     * 图片信息Service.
     */
    private final GraphInfoService graphService;

    /**
     * 房间配套Service.
     */
    private final RoomFacilityService roomFacilityService;

    /**
     * 房间标签Service.
     */
    private final RoomLabelService roomLabelService;

    /**
     * 房间属性值Service.
     */
    private final RoomAttrValueService roomAttrValueService;

    /**
     * 房间支付方式Service.
     */
    private final RoomPaymentTypeService roomPaymentTypeService;

    /**
     * 房间租期Service.
     */
    private final RoomLeaseTermService roomLeaseTermService;

    /**
     * 房间信息Mapper.
     */
    private final RoomInfoMapper roomInfoMapper;

    /**
     * 房间配套Mapper.
     */
    private final FacilityInfoMapper facilityInfoMapper;

    /**
     * 标签信息Mapper.
     */
    private final LabelInfoMapper labelInfoMapper;

    /**
     * 属性值Mapper.
     */
    private final AttrValueMapper attrValueMapper;
    private final PaymentTypeMapper paymentTypeMapper;
    private final LeaseAgreementMapper leaseAgreementMapper;

    /**
     * 保存或更新房间的信息.
     * @param params 房间的信息参数
     */
    @Override
    public void roomSaveOrUpdate(final RoomSaveOrUpdateParam params) {

        log.info("保存或更新房间的信息, params: {}", params);
        RoomInfo roomInfoNew = RoomSaveOrUpdateParam.convertToEntity(params);

        // 是否更新
        Long paramsId = params.getId();
        boolean isUpdate = paramsId != null;
        super.saveOrUpdate(roomInfoNew);

        // 更新操作: 根据原有paramsId删除原有数据，重新保存
        if (isUpdate) {
            removeExistingRelations(paramsId);
            saveRoomInfo(paramsId, params);
        } else {
            // 新增操作: 保存房间的关联关系
            saveRoomInfo(roomInfoNew.getId(), params);
        }
    }

    /**
     * 分页查询房间的信息.
     * @param params 查询参数
     * @return 房间的信息列表
     */
    @Override
    public IPage<RoomPageVo> roomPageItem(final RoomPageItemParam params) {

        log.info("PageQuery room information, params: {}", params);
        // TODO: 重写该方法 2024-10-13
        Page<RoomPageVo> pageVoPage = new Page<>(params.getCurrentPage(), params.getPageSize());
        return roomInfoMapper.roomPageItem(pageVoPage, params);
    }

    /**
     * 更新房间的发布状态.
     * @param params 房间的发布状态参数
     */
    @Override
    public void updateReleaseStatusById(final RoomUpdateStatusByIdParam params) {

        log.info("更新房间的发布状态, params: {}", params);
        LambdaUpdateWrapper<RoomInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(RoomInfo::getId, params.getId());
        updateWrapper.set(RoomInfo::getIsRelease, params.getStatus());
        this.update(updateWrapper);
    }

    /**
     * 根据id查询房间的详情.
     * @param params 房间的id
     * @return 房间的详情信息
     */
    @Override
    public RoomInfoItemVo roomGetDetailById(final RoomGetByIdParam params) {

        log.info("根据id查询房间的详情, params: {}", params);
        Long roomId = params.getId();

        LambdaQueryWrapper<RoomInfo> roomWrapper = new LambdaQueryWrapper<>();
        roomWrapper.eq(RoomInfo::getId, roomId);
        RoomInfo roomEntity = this.getOne(roomWrapper);

        // 房间不存在
        if (roomEntity == null) {
            return null;
        }

        // 查询房间的图片信息
        LambdaQueryWrapper<GraphInfo> graphWrapper = new LambdaQueryWrapper<>();
        graphWrapper.eq(GraphInfo::getItemId, roomId);
        graphWrapper.eq(GraphInfo::getItemType, ItemType.ROOM);
        List<GraphInfo> graphInfos = graphService.list(graphWrapper);

        // 查询房间的配套信息
        List<FacilityInfoListVo> facilityListVo = facilityInfoMapper.listByRoomId(roomId);

        // 查询房间的标签信息
        List<LabelInfoListVo> labelListVo = labelInfoMapper.listByRoomId(roomId);

        // 查询房间的属性值信息
        List<AttrValueListVo> attrValueListVo = attrValueMapper.listByRoomId(roomId);

        // 查询房间的支付方式信息
        List<PaymentTypeListVo> paymentTypeListVo = paymentTypeMapper.listByRoomId(roomId);

        // 查询房间的租期信息
        List<LeaseTermListVo> leaseTermListVo = leaseAgreementMapper.listByRoomId(roomId);

        // 转换为VO对象
        RoomInfoItemVo roomInfoItemVo = RoomInfoItemVo.convertToVo(roomEntity);

        // 构建返回VO
        roomInfoItemVo.setGraphList(BaseVo.convertToVoList(graphInfos, GraphVo.class));
        roomInfoItemVo.setFacilityList(facilityListVo);
        roomInfoItemVo.setLabelList(labelListVo);
        roomInfoItemVo.setAttrValueList(attrValueListVo);
        roomInfoItemVo.setPaymentTypeList(paymentTypeListVo);
        roomInfoItemVo.setLeaseTermList(leaseTermListVo);

        return roomInfoItemVo;
    }

    /**
     * 根据id删除房间信息.
     * @param params 房间的id
     */
    @Override
    public void roomRemoveById(final RoomRemoveByIdParam params) {

        log.info("根据id删除房间信息, params: {}", params);
        this.removeById(params.getId());
        removeExistingRelations(params.getId());

    }

    /**
     * 根据公寓id查询房间列表.
     * @param params 房间的公寓id
     * @return 房间列表
     */
    @Override
    public List<RoomInfoVo> listBasicByApartmentId(final RoomListByApartmentIdParam params) {
        LambdaQueryWrapper<RoomInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoomInfo::getApartmentId, params.getApartmentId());
        List<RoomInfo> roomInfoList = this.list(queryWrapper);
        return BaseVo.convertToVoList(roomInfoList, RoomInfoVo.class);
    }

    /**
     * 删除房间关联关系.
     * @param paramsId 房间id
     */
    private void removeExistingRelations(Long paramsId) {
        // 删除图片关系
        LambdaQueryWrapper<GraphInfo> graphWrapper = new LambdaQueryWrapper<>();
        graphWrapper.eq(GraphInfo::getItemId, paramsId);
        graphWrapper.eq(GraphInfo::getItemType, ItemType.ROOM);
        graphService.remove(graphWrapper);

        // 删除配套关系
        LambdaQueryWrapper<RoomFacility> facilityWrapper = new LambdaQueryWrapper<>();
        facilityWrapper.eq(RoomFacility::getRoomId, paramsId);
        roomFacilityService.remove(facilityWrapper);

        // 删除标签关系
        LambdaQueryWrapper<RoomLabel> labelWrapper = new LambdaQueryWrapper<>();
        labelWrapper.eq(RoomLabel::getRoomId, paramsId);
        roomLabelService.remove(labelWrapper);

        // 删除属性值关系
        LambdaQueryWrapper<RoomAttrValue> attrValueWrapper = new LambdaQueryWrapper<>();
        attrValueWrapper.eq(RoomAttrValue::getRoomId, paramsId);
        roomAttrValueService.remove(attrValueWrapper);

        // 删除支付方式关系
        LambdaQueryWrapper<RoomPaymentType> paymentTypeWrapper = new LambdaQueryWrapper<>();
        paymentTypeWrapper.eq(RoomPaymentType::getRoomId, paramsId);
        roomPaymentTypeService.remove(paymentTypeWrapper);

        // 删除房间-租期关系
        LambdaQueryWrapper<RoomLeaseTerm> leaseTermWrapper = new LambdaQueryWrapper<>();
        leaseTermWrapper.eq(RoomLeaseTerm::getRoomId, paramsId);
        roomLeaseTermService.remove(leaseTermWrapper);
    }

    /**
     * 保存房间的信息.
     *
     * @param paramsId 房间id
     * @param params   房间的信息参数
     */
    private void saveRoomInfo(Long paramsId, RoomSaveOrUpdateParam params) {
        // 保存房间的配套关系
        List<RoomFacility> roomFacilities =
                BaseParams.convertList(params.getFacilityInfoIds(), RoomFacility.class);
        if (!CollectionUtils.isEmpty(roomFacilities)) {
            roomFacilities.forEach(roomFacility -> roomFacility.setRoomId(paramsId));
            roomFacilityService.saveBatch(roomFacilities);
        }

        // 保存房间的标签关系
        List<RoomLabel> roomLabels =
                BaseParams.convertList(params.getLabelInfoIds(), RoomLabel.class);
        if (!CollectionUtils.isEmpty(roomLabels)) {
            roomLabels.forEach(roomLabel -> roomLabel.setRoomId(paramsId));
            roomLabelService.saveBatch(roomLabels);
        }

        // 保存房间的属性值关系
        List<RoomAttrValue> roomAttrValues =
                BaseParams.convertList(params.getAttrValueIds(), RoomAttrValue.class);
        if (!CollectionUtils.isEmpty(roomAttrValues)) {
            roomAttrValues.forEach(roomAttrValue -> roomAttrValue.setRoomId(paramsId));
            roomAttrValueService.saveBatch(roomAttrValues);
        }

        // 保存房间的支付方式关系
        List<RoomPaymentType> roomPaymentTypes =
                BaseParams.convertList(params.getPaymentTypeIds(), RoomPaymentType.class);
        if (!CollectionUtils.isEmpty(roomPaymentTypes)) {
            roomPaymentTypes.forEach(roomPaymentType -> roomPaymentType.setRoomId(paramsId));
            roomPaymentTypeService.saveBatch(roomPaymentTypes);
        }

        // 保存房间的租期关系
        List<RoomLeaseTerm> roomLeaseTerms =
                BaseParams.convertList(params.getLeaseTermIds(), RoomLeaseTerm.class);
        if (!CollectionUtils.isEmpty(roomLeaseTerms)) {
            roomLeaseTerms.forEach(roomLeaseTerm -> roomLeaseTerm.setRoomId(paramsId));
            roomLeaseTermService.saveBatch(roomLeaseTerms);
        }

        // 保存房间的图片关系
        List<GraphInfo> graphInfos =
                BaseParams.convertList(params.getGraphList(), GraphInfo.class);
        if (!CollectionUtils.isEmpty(graphInfos)) {
            graphInfos.forEach(graphInfo -> {
                graphInfo.setItemId(paramsId);
                graphInfo.setItemType(ItemType.ROOM);
            });
            graphService.saveBatch(graphInfos);
        }
    }
}




