package com.atguigu.vo.paymentType;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/

@Schema(description = "支付类型查询响应体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTypeSearchVo extends BaseVo {

    @Schema(description = "付款方式名称")
    private String name;

    @Schema(description = "每次支付租期数")
    private String payMonthCount;

    @Schema(description = "付费说明")
    private String additionalInfo;

}
