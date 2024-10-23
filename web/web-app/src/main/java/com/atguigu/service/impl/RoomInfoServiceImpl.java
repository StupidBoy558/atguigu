package com.atguigu.service.impl;

import com.atguigu.entity.FacilityInfo;
import com.atguigu.entity.GraphInfo;
import com.atguigu.entity.LabelInfo;
import com.atguigu.entity.LeaseTerm;
import com.atguigu.entity.PaymentType;
import com.atguigu.enums.ItemType;
import com.atguigu.exception.LeaseException;
import com.atguigu.login.LoginUserHolder;
import com.atguigu.pojo.vo.apartment.ApartmentItemVo;
import com.atguigu.pojo.vo.attr.AttrValueVo;
import com.atguigu.pojo.vo.fee.FeeValueVo;
import com.atguigu.pojo.vo.graph.GraphVo;
import com.atguigu.pojo.vo.room.RoomDetailVo;
import com.atguigu.pojo.vo.room.RoomItemVo;
import com.atguigu.pojo.vo.room.RoomQueryVo;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.service.ApartmentInfoService;
import com.atguigu.service.AttrValueService;
import com.atguigu.service.BrowsingHistoryService;
import com.atguigu.service.FacilityInfoService;
import com.atguigu.service.FeeValueService;
import com.atguigu.service.GraphInfoService;
import com.atguigu.service.LabelInfoService;
import com.atguigu.service.LeaseTermService;
import com.atguigu.service.PaymentTypeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.RoomInfo;
import com.atguigu.service.RoomInfoService;
import com.atguigu.mapper.RoomInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author wf_wj
 * @description 针对表【room_info(房间信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:35
 */
@Service
@RequiredArgsConstructor
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    /**
     * 房间信息Mapper.
     */
    private final RoomInfoMapper roomInfoMapper;

    /**
     * 公寓信息Service.
     */
    private final ApartmentInfoService apartmentInfoService;

    /**
     * 图片信息Service.
     */
    private final GraphInfoService graphInfoService;

    /**
     * 属性值Service.
     */
    private final AttrValueService attrValueService;

    /**
     * 配套信息Service.
     */
    private final FacilityInfoService facilityInfoService;

    /**
     * 标签信息Service.
     */
    private final LabelInfoService labelInfoService;

    /**
     * 支付方式Service.
     */
    private final PaymentTypeService paymentTypeService;

    /**
     * 杂费Service.
     */
    private final FeeValueService feeValueService;

    /**
     * 租期Service.
     */
    private final LeaseTermService leaseTermService;

    /**
     * 浏览历史Service.
     */
    private final BrowsingHistoryService browsingHistoryService;

    /**
     * 分页查询房间列表.
     *
     * @param page    分页对象
     * @param queryVo 查询条件
     * @return IPage<RoomItemVo> 分页对象
     */
    @Override
    public IPage<RoomItemVo> pageList(Page<RoomItemVo> page, RoomQueryVo queryVo) {

        return roomInfoMapper.pageList(page, queryVo);
    }

    @Override
    public RoomDetailVo getDetailById(Long id) {

        RoomInfo roomInfo = this.getById(id);
        if (roomInfo == null) {
            throw new LeaseException(ResultCodeEnum.ILLEGAL_REQUEST.getCode(), "房间不存在");
        }

        // 查询公寓信息
        ApartmentItemVo apartmentItemVo = apartmentInfoService.getItemVoById(roomInfo.getApartmentId());

        // 查询房间的图片信息
        List<GraphVo> graphVoList = graphInfoService.getGraphVoListByItemId(roomInfo.getId(), ItemType.ROOM);

        // 属性信息列表
        List<AttrValueVo> attrValueVoList = attrValueService.getAttrValueVoByRoomId(roomInfo.getId());

        // 配套信息列表
        List<FacilityInfo> facilityInfoList = facilityInfoService.getFacilityInfoByRoomId(roomInfo.getId());

        // 标签信息列表
        List<LabelInfo> labelInfoList = labelInfoService.getLabelInfoByRoomId(roomInfo.getId());

        // 支付方式列表
        List<PaymentType> paymentTypeList = paymentTypeService.getPaymentTypeByRoomId(roomInfo.getId());

        // 杂费列表
        List<FeeValueVo> feeValueVoList = feeValueService.getFeeValueByApartmentId(roomInfo.getApartmentId());

        // 租期列表
        List<LeaseTerm> leaseTermList = leaseTermService.getLeaseTermByRoomId(roomInfo.getId());


        RoomDetailVo roomDetailVo = new RoomDetailVo();
        BeanUtils.copyProperties(roomInfo, roomDetailVo);
        roomDetailVo.setApartmentItemVo(apartmentItemVo);
        roomDetailVo.setGraphVoList(graphVoList);
        roomDetailVo.setAttrValueVoList(attrValueVoList);
        roomDetailVo.setFacilityInfoList(facilityInfoList);
        roomDetailVo.setLabelInfoList(labelInfoList);
        roomDetailVo.setPaymentTypeList(paymentTypeList);
        roomDetailVo.setFeeValueVoList(feeValueVoList);
        roomDetailVo.setLeaseTermList(leaseTermList);

        // 保存浏览历史
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        browsingHistoryService.saveBrowsingHistory(roomInfo.getId(), userId);

        return roomDetailVo;
    }

    @Override
    public IPage<RoomItemVo> pageListByApartmentId(Page<RoomItemVo> page, Long id) {
        return roomInfoMapper.pageListByApartmentId(page, id);
    }
}




