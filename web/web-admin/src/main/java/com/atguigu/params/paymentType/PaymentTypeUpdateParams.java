package com.atguigu.params.paymentType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/
@Schema(name = "PaymentTypeUpdateParams", description = "支付方式修改请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTypeUpdateParams implements Serializable {

    @NotNull(message = "支付方式id不能为空")
    @Schema(description = "支付方式id")
    private Long id;

    @NotBlank(message = "付款方式名称不能为空")
    @Schema(description = "付款方式名称")
    private String name;

    @NotBlank(message = "每次支付租期数不能为空")
    @Schema(description = "每次支付租期数")
    private String payMonthCount;

    @NotBlank(message = "付费说明不能为空")
    @Schema(description = "付费说明")
    private String additionalInfo;

}
