package com.atguigu.params.system;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 根据id删除用户信息参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "根据id删除用户信息参数")
public class SystemUserRemoveByIdParams extends BaseParams {
    /**
     * 用户id.
     */
    @Schema(description = "用户id")
    private Long id;
}
