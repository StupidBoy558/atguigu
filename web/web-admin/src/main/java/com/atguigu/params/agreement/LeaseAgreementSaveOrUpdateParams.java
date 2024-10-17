package com.atguigu.params.agreement;

import com.atguigu.entity.LeaseAgreement;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 租赁协议保存或更新参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "租赁协议保存或更新参数")
public class LeaseAgreementSaveOrUpdateParams extends BaseParams {

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
     * 租约开始日期.
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
     * 租约来源（1:新签，2:续约）.
     */
    @Schema(description = "租约来源")
    private Integer sourceType;

    /**
     * 备注信息.
     */
    @Schema(description = "备注信息")
    private String additionalInfo;

    /**
     * 租赁协议参数转换为实体类
     *
     * @param params 租赁协议保存或更新参数
     * @return 租赁协议实体
     */
    public static LeaseAgreement convertToEntity(final LeaseAgreementSaveOrUpdateParams params) {
        if (params == null) {
            return null;
        }
        LeaseAgreement leaseAgreement = new LeaseAgreement();
        BeanUtils.copyProperties(params, leaseAgreement);
        return leaseAgreement;
    }

}
