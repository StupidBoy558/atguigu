package com.atguigu.params.login;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 登录参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/15
 **/
@Data
@Schema(description = "登录参数")
@AllArgsConstructor
@NoArgsConstructor
public class LoginParams extends BaseParams {

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
     * 验证码key.
     */
    @Schema(description = "验证码key")
    private String captchaKey;

    /**
     * 验证码code.
     */
    @Schema(description = "验证码code")
    private String captchaCode;

}
