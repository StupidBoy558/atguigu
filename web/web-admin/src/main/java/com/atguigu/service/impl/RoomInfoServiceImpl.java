package com.atguigu.service.impl;

import com.atguigu.entity.GraphInfo;
import com.atguigu.entity.RoomAttrValue;
import com.atguigu.entity.RoomFacility;
import com.atguigu.entity.RoomLabel;
import com.atguigu.entity.RoomLeaseTerm;
import com.atguigu.entity.RoomPaymentType;
import com.atguigu.enums.ItemType;
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
import com.atguigu.vo.room.RoomPageVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.RoomInfo;
import com.atguigu.service.RoomInfoService;
import com.atguigu.mapper.RoomInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
            // 保存数据
        }

        // 保存数据


    }

    /**
     * 分页查询房间的信息.
     *
     * @param params 查询参数
     * @return 房间信息列表
     */
    @Override
    public IPage<RoomPageVo> roomPageItem(final RoomPageItemParam params) {
        IPage<RoomPageVo> o = null;
        return o;
    }

    /**
     * 更新房间的发布状态.
     *
     * @param params 房间的发布状态参数
     */
    @Override
    public void updateReleaseStatusById(final RoomUpdateStatusByIdParam params) {

    }

    /**
     * 根据id获取房间详细信息.
     *
     * @param params 房间的id
     */
    @Override
    public void roomGetDetailById(final RoomGetByIdParam params) {

    }

    /**
     * 根据id删除房间信息.
     *
     * @param params 房间的id
     */
    @Override
    public void roomRemoveById(final RoomRemoveByIdParam params) {

    }

    /**
     * 根据公寓id查询房间列表.
     *
     * @param params 公寓id
     */
    @Override
    public void listBasicByApartmentId(final RoomListByApartmentIdParam params) {

    }

    /**
     * 删除房间关联关系.
     *
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
}




