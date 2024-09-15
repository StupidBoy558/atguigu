package com.atguigu.params.paymentType;

import com.atguigu.params.BaseParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/
@Schema(name = "PaymentTypeSaveParam", description = "新增支付方式请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTypeSaveParam extends BaseParam {

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
