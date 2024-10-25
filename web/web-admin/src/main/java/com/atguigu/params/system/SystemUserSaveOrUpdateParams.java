package com.atguigu.params.system;

import com.atguigu.entity.SystemUser;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description: 保存或更新后台用户信息请求体.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "保存或更新后台用户信息")
public class SystemUserSaveOrUpdateParams extends BaseParams {
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
     * 账号状态.
     */
    @Schema(description = "账号状态")
    private Integer status;

    /**
     * 转换为实体类.
     *
     * @param params 请求参数
     * @return SystemUser
     */
    public static SystemUser convertToEntity(SystemUserSaveOrUpdateParams params) {
        SystemUser systemUser = new SystemUser();
        BeanUtils.copyProperties(params, systemUser);
        return systemUser;
    }
}
