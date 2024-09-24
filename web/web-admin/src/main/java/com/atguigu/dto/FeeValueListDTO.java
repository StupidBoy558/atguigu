package com.atguigu.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/24
 **/
@Data
@Schema(name = "FeeValueListDTO", description = "费用值列表响应体")
public class FeeValueListDTO {

    /**
     * id.
     */
    @Schema(description = "id")
    private Long id;

    /**
     * 费用value.
     */
    @Schema(description = "费用value")
    private String name;

    /**
     * 收费单位.
     */
    @Schema(description = "收费单位")
    private String unit;

    /**
     * 费用所对的fee_key.
     */
    @Schema(description = "费用所对的fee_key")
    private Long feeKeyId;

}
