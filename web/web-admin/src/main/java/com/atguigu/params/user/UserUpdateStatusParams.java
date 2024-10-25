package com.atguigu.params.user;

import com.atguigu.enums.BaseStatus;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 根据用户id更新账号状态.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(name = "UserUpdateStatusParams", description = "根据用户id更新账号状态")
public class UserUpdateStatusParams extends BaseParams {

    /**
     * 用户id.
     */
    @Schema(description = "用户id")
    private Long id;

    /**
     * 账号状态.
     */
    @Schema(description = "账号状态")
    private BaseStatus status;
}
