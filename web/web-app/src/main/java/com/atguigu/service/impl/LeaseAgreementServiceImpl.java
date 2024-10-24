package com.atguigu.service.impl;

import com.atguigu.entity.LeaseTerm;
import com.atguigu.enums.ItemType;
import com.atguigu.mapper.ApartmentInfoMapper;
import com.atguigu.mapper.RoomInfoMapper;
import com.atguigu.pojo.vo.agreement.AgreementDetailVo;
import com.atguigu.pojo.vo.agreement.AgreementItemVo;
import com.atguigu.pojo.vo.graph.GraphVo;
import com.atguigu.service.GraphInfoService;
import com.atguigu.service.LeaseTermService;
import com.atguigu.service.PaymentTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.LeaseAgreement;
import com.atguigu.service.LeaseAgreementService;
import com.atguigu.mapper.LeaseAgreementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【lease_agreement(租约信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:34
 */
@Service
@RequiredArgsConstructor
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
        implements LeaseAgreementService {

    /**
     * 租约信息表Mapper.
     */
    private final LeaseAgreementMapper leaseAgreementMapper;

    private final ApartmentInfoMapper apartmentInfoMapper;

    private final RoomInfoMapper roomInfoMapper;

    private final PaymentTypeService paymentTypeService;

    private final LeaseTermService leaseTermService;

    private final GraphInfoService graphInfoService;

    /**
     * 根据公寓id获取最小租金.
     *
     * @param id 公寓id
     * @return BigDecimal 最小租金.
     */
    @Override
    public BigDecimal getMinRentByApartmentId(Long id) {

        return leaseAgreementMapper.getMinRentByApartmentId(id);
    }

    /**
     * 根据用户id获取租约列表.
     *
     * @param username 用户phone
     * @return List<AgreementItemVo>
     */
    @Override
    public List<AgreementItemVo> ListItemByPhone(final String username) {


        return leaseAgreementMapper.ListItemByPhone(username);
    }

    /**
     * 根据id获取租约详细信息.
     *
     * @param id 租约id
     * @return AgreementDetailVo
     */
    @Override
    public AgreementDetailVo getDetailById(Long id) {

        LeaseAgreement leaseAgreement = this.getById(id);
        if (leaseAgreement == null) {
            return null;
        }

        // 获取公寓信息
        apartmentInfoMapper.selectById(leaseAgreement.getApartmentId());

        // 查询房间的信息
        roomInfoMapper.selectById(leaseAgreement.getRoomId());

        // 查询支付方式
        paymentTypeService.getById(leaseAgreement.getPaymentTypeId());

        // 查询公寓图片列表
        List<GraphVo> graphVoListByItemId1 =
                graphInfoService.getGraphVoListByItemId(leaseAgreement.getApartmentId(), ItemType.APARTMENT);

        // 查询房间的图片列表
        List<GraphVo> graphVoListByItemId =
                graphInfoService.getGraphVoListByItemId(leaseAgreement.getRoomId(), ItemType.ROOM);

        // 查询租期月数
        LeaseTerm leaseTerm = leaseTermService.getById(leaseAgreement.getLeaseTermId());

        AgreementDetailVo agreementDetailVo = new AgreementDetailVo();
        BeanUtils.copyProperties(leaseAgreement, agreementDetailVo);
        agreementDetailVo.setApartmentGraphVoList(graphVoListByItemId1);
        agreementDetailVo.setRoomGraphVoList(graphVoListByItemId);
        agreementDetailVo.setLeaseTermMonthCount(leaseTerm.getMonthCount());
        agreementDetailVo.setLeaseTermUnit(leaseTerm.getUnit());
        return agreementDetailVo;
    }
}




