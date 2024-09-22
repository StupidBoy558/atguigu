package com.atguigu.params.paymentType;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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

@Schema(name = "PaymentTypeSearchParams", description = "支付方式查询参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTypeSearchParams implements Serializable {



    @Schema(description = "支付方式id")
    @NotNull(message = "支付方式id不能为空")
    @JsonProperty("id")
    private Long id;

}
