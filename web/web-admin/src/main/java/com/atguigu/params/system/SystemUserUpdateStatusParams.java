package com.atguigu.params.system;

import com.atguigu.enums.BaseStatus;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 更新用户状态参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "更新用户状态参数")
public class SystemUserUpdateStatusParams extends BaseParams {

    /**
     * 用户id.
     */
    @Schema(description = "用户id")
    private Long id;

    /**
     * 用户状态.
     */
    @Schema(description = "用户状态")
    private BaseStatus status;
}
