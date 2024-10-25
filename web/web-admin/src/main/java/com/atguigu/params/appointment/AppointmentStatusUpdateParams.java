package com.atguigu.params.appointment;

import com.atguigu.enums.AppointmentStatus;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 预约看房状态更新参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/13
 **/
@Data
public class AppointmentStatusUpdateParams extends BaseParams {

    /**
     * 预约看房id.
     */
    @Schema(description = "预约看房id")
    private Long id;

    /**
     * 预约看房状态.
     */
    @Schema(description = "预约看房状态")
    private AppointmentStatus status;
}
