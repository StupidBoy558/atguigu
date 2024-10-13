package com.atguigu.params.appointment;

import com.atguigu.enums.AppointmentStatus;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 预约看房分页查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/13
 **/
@Data
public class AppointmentPageParams extends BaseParams {
    /**
     * 租房状态.
     */
    @Schema(description = "租房状态")
    private AppointmentStatus status;

    /**
     * 分页查询参数current.
     */
    @Schema(description = "分页查询参数current")
    private Long current;

    /**
     * 分页查询参数size.
     */
    @Schema(description = "分页查询参数size")
    private Long size;
}
