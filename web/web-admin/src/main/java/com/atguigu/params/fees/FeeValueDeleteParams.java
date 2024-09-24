package com.atguigu.params.fees;

import com.atguigu.params.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/23
 **/
@Data
@Schema(name = "FeeValueDeleteParams", description = "删除杂费值参数")
public class FeeValueDeleteParams extends BaseParams {

    /**
     * 杂费值id.
     */
    @NotNull(message = "id不能为空")
    @Schema(name = "id", description = "杂费值id")
    private Long id;

}
