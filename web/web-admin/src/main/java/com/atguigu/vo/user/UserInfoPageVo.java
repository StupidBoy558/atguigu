package com.atguigu.vo.user;

import com.atguigu.vo.BaseVo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 用户信息分页查询返回参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Schema(name = "UserInfoPageVo", description = "用户信息分页查询返回参数")
@Data
public class UserInfoPageVo extends BaseVo {

    /**
     * 用户id.
     */
    @Schema(description = "用户id")
    private Long id;

    /**
     * 手机号码（用做登录用户名）.
     */
    @Schema(description = "手机号码（用做登录用户名）")
    private String phone;

    /**
     * 密码.
     */
    @Schema(description = "密码")
    private String password;

    /**
     * 头像url.
     */
    @Schema(description = "头像url")
    private String avatarUrl;

    /**
     * 昵称.
     */
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 账号状态.
     */
    @Schema(description = "账号状态")
    private Integer status;

}
