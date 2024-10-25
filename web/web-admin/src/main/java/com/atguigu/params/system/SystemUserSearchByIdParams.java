package com.atguigu.params.system;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: 根据id查询后台用户信息参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "根据id查询后台用户信息参数")
public class SystemUserSearchByIdParams extends BaseParams {

    /**
     * 用户id.
     */
    @NotNull
    @Schema(description = "用户id")
    private Long id;
}
