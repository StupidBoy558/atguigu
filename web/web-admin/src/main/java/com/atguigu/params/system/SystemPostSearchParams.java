package com.atguigu.params.system;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: 岗位列表查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "岗位列表查询参数")
public class SystemPostSearchParams extends BaseParams {

    /**
     * 岗位id.
     */
    @NotNull
    @Schema(description = "岗位id")
    private Long id;
}
