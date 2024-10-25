package com.atguigu.vo.login;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description: 验证码信息.
 * @Author: dansheng
 * @CreateTime: 2024/10/15
 **/
@Data
@Schema(description = "验证码信息")
@AllArgsConstructor
public class CaptchaVo extends BaseVo {

    @Schema(description = "验证码图片信息")
    private String image;

    @Schema(description = "验证码Key")
    private String key;
}
