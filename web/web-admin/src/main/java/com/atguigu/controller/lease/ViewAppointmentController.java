package com.atguigu.controller.lease;

import com.atguigu.params.appointment.AppointmentPageParams;
import com.atguigu.params.appointment.AppointmentStatusUpdateParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.ViewAppointmentService;
import com.atguigu.vo.appointment.AppointmentPageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 预约看房管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/13
 **/
@RestController
@RequestMapping("/admin/appointment")
@Tag(name = "ViewAppointmentController", description = "预约看房管理")
@Slf4j
@RequiredArgsConstructor
public class ViewAppointmentController {

    /**
     * 预约看房信息Service.
     */
    private final ViewAppointmentService appointmentService;

    /**
     * 分页查询预约看房信息.
     *
     * @param params 分页查询参数
     * @return 预约看房信息分页数据
     */
    @Operation(summary = "分页查询预约看房信息")
    @PostMapping("/page")
    public ResponseData<IPage<AppointmentPageVo>> appointmentPageItem(
            @RequestBody @Validated final AppointmentPageParams params) {

        log.info("分页查询预约看房信息: {}", params);
        return ResponseData.ok(appointmentService.appointmentPageItem(params));
    }

    /**
     * 根据id更新预约看房状态.
     *
     * @param params 预约看房状态更新参数
     * @return 更新结果
     */
    @Operation(summary = "根据id更新预约看房状态")
    @PostMapping("/updateStatusById")
    public ResponseData<Void> appointmentUpdateStatusById(
            @RequestBody @Validated final AppointmentStatusUpdateParams params) {

        log.info("根据id更新预约看房状态: {}", params);
        appointmentService.appointmentUpdateStatusById(params);
        return ResponseData.ok();
    }
}
