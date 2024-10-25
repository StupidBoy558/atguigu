package com.atguigu.vo.system;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 系统用户信息.
 * @Author: dansheng
 * @CreateTime: 2024/10/16
 **/
@Data
@Schema(description = "系统用户信息")
public class SystemUserInfoVo extends BaseVo {

    @Schema(description = "用户姓名")
    private String name;

    @Schema(description = "用户头像")
    private String avatarUrl;
}
