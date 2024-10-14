package com.atguigu.params.user;

import com.atguigu.enums.BaseStatus;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 用户信息分页查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Schema(name = "UserInfoPageParams", description = "用户信息分页查询参数")
@Data
public class UserInfoPageParams extends BaseParams {

    /**
     * 当前页码.
     */
    @Schema(description = "当前页码")
    private Long current;

    /**
     * 每页显示数量.
     */
    @Schema(description = "每页显示数量")
    private Long size;

    /**
     * 用户名称.
     */
    @Schema(description = "用户手机号码")
    private String phone;

    /**
     * 用户账号状态.
     */
    @Schema(description = "用户账号状态")
    private BaseStatus status;
}
