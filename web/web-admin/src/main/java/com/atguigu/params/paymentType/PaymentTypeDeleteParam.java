package com.atguigu.params.paymentType;

import com.atguigu.params.BaseParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/
@Schema(name = "PaymentTypeDeleteParam", description = "删除支付方式请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTypeDeleteParam extends BaseParam {

    @NotNull(message = "支付方式id不能为空")
    @Schema(description = "支付方式id")
    private Long id;



}
