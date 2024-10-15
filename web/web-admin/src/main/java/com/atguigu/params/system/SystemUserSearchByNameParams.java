package com.atguigu.params.system;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 根据用户名查询用户信息参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "根据用户名查询用户信息参数")
public class SystemUserSearchByNameParams extends BaseParams {

    /**
     * 用户名.
     */
    @Schema(description = "用户名")
    private String username;
}
