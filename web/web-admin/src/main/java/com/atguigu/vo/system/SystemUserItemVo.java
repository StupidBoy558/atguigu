package com.atguigu.vo.system;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 用户信息.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Schema(description = "用户信息")
@Data
public class SystemUserItemVo extends BaseVo {

    /**
     * 员工id.
     */
    @Schema(description = "员工id")
    private Long id;

    /**
     * 用户名.
     */
    @Schema(description = "用户名")
    private String username;

    /**
     * 密码.
     */
    @Schema(description = "密码")
    private String password;

    /**
     * 姓名.
     */
    @Schema(description = "姓名")
    private String name;

    /**
     * 用户类型.
     */
    @Schema(description = "用户类型")
    private Integer type;

    /**
     * 手机号码.
     */
    @Schema(description = "手机号码")
    private String phone;

    /**
     * 头像地址.
     */
    @Schema(description = "头像地址")
    private String avatarUrl;

    /**
     * 备注信息.
     */
    @Schema(description = "备注信息")
    private String additionalInfo;

    /**
     * 岗位id.
     */
    @Schema(description = "岗位id")
    private Long postId;

    /**
     * 岗位名称.
     */
    @Schema(description = "岗位名称")
    private String postName;

}
