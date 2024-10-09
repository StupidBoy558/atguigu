package com.atguigu.vo.fees;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: FeeValueListVo
 * @Author: dansheng
 * @CreateTime: 2024/10/9
 **/
@Data
@Schema(name = "费用值列表响应体", description = "费用值列表")
public class FeeValueListVo extends BaseVo {

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

    /**
     * 费用所对的fee_key.
     */
    @Schema(description = "费用所对的fee_key")
    private String feeKeyName;
}
