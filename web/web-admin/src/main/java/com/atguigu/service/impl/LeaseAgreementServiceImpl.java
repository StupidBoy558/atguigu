package com.atguigu.service.impl;

import com.atguigu.entity.ApartmentInfo;
import com.atguigu.entity.LeaseTerm;
import com.atguigu.entity.PaymentType;
import com.atguigu.entity.RoomInfo;
import com.atguigu.exception.LeaseException;
import com.atguigu.params.agreement.AgreementPageParams;
import com.atguigu.params.agreement.AgreementRemoveByIdParams;
import com.atguigu.params.agreement.AgreementSearchParams;
import com.atguigu.params.agreement.AgreementUpdateStatusByIdParams;
import com.atguigu.params.agreement.LeaseAgreementSaveOrUpdateParams;
import com.atguigu.result.ResponseData;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.service.ApartmentInfoService;
import com.atguigu.service.LeaseTermService;
import com.atguigu.service.PaymentTypeService;
import com.atguigu.service.RoomInfoService;
import com.atguigu.vo.agreement.AgreementPageVo;
import com.atguigu.vo.agreement.AgreementSearchVo;
import com.atguigu.vo.apartment.ApartmentItemVo;
import com.atguigu.vo.leaseTerm.LeaseTermSearchVo;
import com.atguigu.vo.paymentType.PaymentTypeSearchVo;
import com.atguigu.vo.room.RoomInfoItemVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.LeaseAgreement;
import com.atguigu.service.LeaseAgreementService;
import com.atguigu.mapper.LeaseAgreementMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: wf_wj
 * @description: 针对表【lease_agreement(租约信息表)】的数据库操作Service实现
 * @createDate: 2024-09-16 22:26:48
*/
@Service
@Slf4j
@RequiredArgsConstructor
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
        implements LeaseAgreementService {

    private final ApartmentInfoService apartmentInfoService;

    private final RoomInfoService roomInfoService;

    private final PaymentTypeService paymentTypeService;

    private final LeaseTermService leaseTermService;

    /**
     * 保存或更新租约信息.
     *
     * @param params 保存或更新租约信息参数
     */
    @Override
    public void agreementSaveOrUpdate(final LeaseAgreementSaveOrUpdateParams params) {

        log.info("保存或更新租约信息: {}", params);
        LeaseAgreement leaseAgreementNew = LeaseAgreementSaveOrUpdateParams.convertToEntity(params);
        if (params.getId() == null) {
            this.save(leaseAgreementNew);
        } else {
            this.updateById(leaseAgreementNew);
        }

    }

    /**
     * 分页查询租约信息.
     *
     * @param pageData 分页查询租约信息参数
     * @return 分页查询租约信息结果
     */
    @Override
    public IPage<AgreementPageVo> agreementPageItem(final AgreementPageParams pageData) {

        log.info("分页查询租约信息: {}", pageData);
        Page<LeaseAgreement> page = new Page<>(pageData.getCurrent(), pageData.getSize());
        return baseMapper.pageList(page, pageData);
    }

    /**
     * 根据ID查询租约信息.
     *
     * @param params 根据ID查询租约信息参数
     * @return 根据ID查询租约信息结果
     */
    @Override
    public AgreementSearchVo agreementSearchById(final AgreementSearchParams params) {

        // 根据ID查询租约信息
        Long agreementId = params.getId();
        LeaseAgreement leaseAgreement = this.getById(agreementId);
        if (leaseAgreement == null) {
            throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "租约信息不存在");
        }

        LambdaQueryWrapper<ApartmentInfo> apartmentQueryWrapper = new LambdaQueryWrapper<>();
        apartmentQueryWrapper.eq(ApartmentInfo::getId, leaseAgreement.getApartmentId());
        ApartmentInfo apartmentInfo = apartmentInfoService.getOne(apartmentQueryWrapper);
        ApartmentItemVo apartmentItemVo = ApartmentItemVo.convertToVo(apartmentInfo);

        LambdaQueryWrapper<RoomInfo> roomQueryWrapper = new LambdaQueryWrapper<>();
        roomQueryWrapper.eq(RoomInfo::getId, leaseAgreement.getRoomId());
        RoomInfo roomInfo = roomInfoService.getOne(roomQueryWrapper);
        RoomInfoItemVo roomInfoItemVo = RoomInfoItemVo.convertToVo(roomInfo);

        LambdaQueryWrapper<PaymentType> paymentTypeQueryWrapper = new LambdaQueryWrapper<>();
        paymentTypeQueryWrapper.eq(PaymentType::getId, leaseAgreement.getPaymentTypeId());
        PaymentType paymentType = paymentTypeService.getOne(paymentTypeQueryWrapper);
        PaymentTypeSearchVo paymentTypeSearchVo = PaymentTypeSearchVo.convertToVo(paymentType);

        LambdaQueryWrapper<LeaseTerm> leaseTermQueryWrapper = new LambdaQueryWrapper<>();
        leaseTermQueryWrapper.eq(LeaseTerm::getId, leaseAgreement.getLeaseTermId());
        LeaseTerm leaseTerm = leaseTermService.getOne(leaseTermQueryWrapper);
        LeaseTermSearchVo leaseTermSearchVo = LeaseTermSearchVo.convertToVo(leaseTerm);

        // 将查询结果转换为VO对象
        AgreementSearchVo agreementSearchVo = AgreementSearchVo.convertToVo(leaseAgreement);
        agreementSearchVo.setApartmentInfo(apartmentItemVo);
        agreementSearchVo.setRoomInfo(roomInfoItemVo);
        agreementSearchVo.setPaymentType(paymentTypeSearchVo);
        agreementSearchVo.setLeaseTerm(leaseTermSearchVo);


        // 返回查询结果
        return agreementSearchVo;

    }

    /**
     * 根据ID删除租约信息.
     * @param params 根据ID删除租约信息参数
     */
    @Override
    public void agreementRemoveById(final AgreementRemoveByIdParams params) {
        boolean b = this.removeById(params.getId());
        if (!b) {
            throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "租约信息删除失败");
        }
    }

    @Override
    public void agreementUpdateStatusById(final AgreementUpdateStatusByIdParams params) {

        LambdaUpdateWrapper<LeaseAgreement> agreementUpdateWrapper = new LambdaUpdateWrapper<>();
        agreementUpdateWrapper.eq(LeaseAgreement::getId, params.getId());
        agreementUpdateWrapper.set(LeaseAgreement::getStatus, params.getStatus());
        boolean b = this.update(agreementUpdateWrapper);
        if (!b) {
            throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "更新租约状态失败");
        }
    }
}




