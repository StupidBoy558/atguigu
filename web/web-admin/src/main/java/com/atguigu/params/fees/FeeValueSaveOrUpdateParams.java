package com.atguigu.params.fees;

import com.atguigu.entity.FeeValue;
import com.atguigu.params.BaseParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/23
 **/
@Data
@Schema(name = "FeeKeySaveOrUpdateParams", description = "保存或更新费用key")
public class FeeValueSaveOrUpdateParams extends BaseParams {

    /**
     * id.
     */
    @JsonProperty("id")
    @Schema(description = "id")
    private Long id;

    /**
     * 费用value.
     */
    @JsonProperty("name")
    @Schema(description = "费用value")
    @NotBlank(message = "费用value不能为空")
    private String name;

    /**
     * 收费单位.
     */
    @JsonProperty("unit")
    @Schema(description = "收费单位")
    @NotBlank(message = "收费单位不能为空")
    private String unit;

    /**
     * 费用所对的fee_key.
     */
    @JsonProperty("feeKeyId")
    @Schema(description = "费用所对的fee_key_id")
    @NotNull(message = "费用所对的fee_key_id不能为空")
    private Long feeKeyId;

    /**
     * feeValueParams转换为FeeValue.
     * @param params FeeValueSaveOrUpdateParams RequestParams
     * @return FeeValue
     */
    public static FeeValue convertToEntity(
            final FeeValueSaveOrUpdateParams params) {
        FeeValue feeValue = new FeeValue();
        BeanUtils.copyProperties(params, feeValue);
        return feeValue;
    }

}
