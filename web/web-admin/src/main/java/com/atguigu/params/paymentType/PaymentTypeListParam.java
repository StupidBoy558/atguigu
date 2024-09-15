package com.atguigu.params.paymentType;

import com.atguigu.params.BaseParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/
@Data
@Schema(name = "PaymentTypeListParam", description = "支付方式请求体")
public class PaymentTypeListParam extends BaseParam {


    @Schema(description = "付款方式名称")
    private String name;

    @Schema(description = "每次支付租期数")
    private String payMonthCount;

    @Schema(description = "付费说明")
    private String additionalInfo;

}
