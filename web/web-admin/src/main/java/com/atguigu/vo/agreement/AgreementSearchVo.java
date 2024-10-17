package com.atguigu.vo.agreement;

import com.atguigu.entity.LeaseAgreement;
import com.atguigu.vo.BaseVo;
import com.atguigu.vo.apartment.ApartmentItemVo;
import com.atguigu.vo.leaseTerm.LeaseTermSearchVo;
import com.atguigu.vo.paymentType.PaymentTypeSearchVo;
import com.atguigu.vo.room.RoomInfoItemVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 租赁协议查询Vo.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(name = "AgreementSearchVo", description = "租赁协议查询Vo")
public class AgreementSearchVo extends BaseVo {
    /**
     * 租约id.
     */
    @Schema(description = "租约id")
    private Long id;

    /**
     * 承租人手机号码.
     */
    @Schema(description = "承租人手机号码")
    private String phone;

    /**
     * 承租人姓名.
     */
    @Schema(description = "承租人姓名")
    private String name;

    /**
     * 承租人身份证号码.
     */
    @Schema(description = "承租人身份证号码")
    private String identificationNumber;

    /**
     * 签约公寓id.
     */
    @Schema(description = "签约公寓id")
    private Long apartmentId;

    /**
     * 签约房间id.
     */
    @Schema(description = "签约房间id")
    private Long roomId;

    /**
     * 租约开始日期
     */
    @Schema(description = "租约开始日期")
    private Date leaseStartDate;

    /**
     * 租约结束日期.
     */
    @Schema(description = "租约结束日期")
    private Date leaseEndDate;

    /**
     * 租期id.
     */
    @Schema(description = "租期id")
    private Long leaseTermId;

    /**
     * 租金（元/月）.
     */
    @Schema(description = "租金（元/月）")
    private BigDecimal rent;

    /**
     * 押金（元）.
     */
    @Schema(description = "押金（元）")
    private BigDecimal deposit;

    /**
     * 支付类型id.
     */
    @Schema(description = "支付类型id")
    private Long paymentTypeId;

    /**
     * 租约状态（1:签约待确认，2:已签约，3:已取消，4:已到期，5:退租待确认，6:已退租，7:续约待确认）.
     */
    @Schema(description = "租约状态")
    private Integer status;

    /**
     * 租约来源（1:新签，2:续约）
     */
    @Schema(description = "租约来源")
    private Integer sourceType;

    /**
     * 备注信息.
     */
    @Schema(description = "备注信息")
    private String additionalInfo;

    /**
     * 签约公寓信息.
     */
    @Schema(description = "签约公寓信息")
    private ApartmentItemVo apartmentInfo;

    /**
     * 签约房间的信息.
     */
    @Schema(description = "签约房间信息")
    private RoomInfoItemVo roomInfo;

    /**
     * 支付方式.
     */
    @Schema(description = "支付方式")
    private PaymentTypeSearchVo paymentType;

    /**
     * 租期.
     */
    @Schema(description = "租期")
    private LeaseTermSearchVo leaseTerm;

    /**
     * 将LeaseAgreement转换为AgreementSearchVo.
     *
     * @param leaseAgreement 租约信息
     * @return 租约查询Vo
     */
    public static AgreementSearchVo convertToVo(final LeaseAgreement leaseAgreement) {
        AgreementSearchVo agreementSearchVo = new AgreementSearchVo();
        BeanUtils.copyProperties(leaseAgreement, agreementSearchVo);
        return agreementSearchVo;
    }
}
