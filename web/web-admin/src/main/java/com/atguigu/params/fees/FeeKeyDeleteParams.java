package com.atguigu.params.fees;

import com.atguigu.params.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: FeeKeyDeleteParams
 * @Author: dansheng
 * @CreateTime: 2024/9/23
 **/
@Data
@Schema(name = "FeeKeyDeleteParams", description = "删除费用key")
public class FeeKeyDeleteParams extends BaseParams {

    /**
     * 费用key id.
     */
    @NotNull(message = "费用key id不能为空")
    @Schema(description = "费用key id")
    private Long id;

}
