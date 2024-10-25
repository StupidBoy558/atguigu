package com.atguigu.params.system;

import com.atguigu.enums.BaseStatus;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 岗位状态更新参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "岗位状态更新参数")
public class SystemPostUpdateStatusParams extends BaseParams {

    /**
     * 岗位id.
     */
    @Schema(description = "岗位id")
    private Long id;

    /**
     * 状态.
     */
    @Schema(description = "状态")
    private BaseStatus status;
}
