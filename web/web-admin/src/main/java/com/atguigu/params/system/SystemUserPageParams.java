package com.atguigu.params.system;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 用户列表查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "用户列表查询参数")
public class SystemUserPageParams extends BaseParams {

    /**
     * 当前页.
     */
    @Schema(description = "当前页")
    private Long current;

    /**
     * 每页显示的条数.
     */
    @Schema(description = "每页显示的条数")
    private Long size;

    /**
     * 员工姓名.
     */
    @Schema(description = "员工姓名")
    private String name;

    /**
     * 手机号码.
     */
    @Schema(description = "手机号码")
    private String phone;
}
