package com.atguigu.vo.paymentType;

import com.atguigu.entity.PaymentType;
import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @Description: 支付类型查询响应体.
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/

@Schema(description = "支付类型查询响应体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTypeSearchVo extends BaseVo {

    /**
     * 支付类型id.
     */
    @Schema(description = "支付类型id")
    private Long id;

    /**
     * 付款方式名称.
     */
    @Schema(description = "付款方式名称")
    private String name;

    /**
     * 付款方式描述.
     */
    @Schema(description = "每次支付租期数")
    private String payMonthCount;

    /**
     * 付款方式描述.
     */
    @Schema(description = "付费说明")
    private String additionalInfo;

    /**
     * 支付方式vo.
     *
     * @param paymentType 支付方式实体
     * @return 支付方式vo
     */
    public static PaymentTypeSearchVo convertToVo(PaymentType paymentType) {
        PaymentTypeSearchVo paymentTypeSearchVo = new PaymentTypeSearchVo();
        BeanUtils.copyProperties(paymentType, paymentTypeSearchVo);
        return paymentTypeSearchVo;
    }
}
