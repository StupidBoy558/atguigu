package com.atguigu.controller.appointment;


import com.atguigu.entity.ViewAppointment;
import com.atguigu.login.LoginUserHolder;
import com.atguigu.pojo.vo.appointment.AppointmentDetailVo;
import com.atguigu.pojo.vo.appointment.AppointmentItemVo;
import com.atguigu.result.ResponseData;
import com.atguigu.service.ViewAppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "看房预约信息")
@RestController
@RequiredArgsConstructor
@RequestMapping("/app/appointment")
public class ViewAppointmentController {

    private final ViewAppointmentService viewAppointmentService;

    @Operation(summary = "保存或更新看房预约")
    @PostMapping("/saveOrUpdate")
    public ResponseData saveOrUpdate(@RequestBody ViewAppointment viewAppointment) {

        Long userId = LoginUserHolder.getLoginUser().getUserId();
        viewAppointment.setUserId(userId);
        viewAppointmentService.saveOrUpdate(viewAppointment);
        return ResponseData.ok();
    }

    @Operation(summary = "查询个人预约看房列表")
    @GetMapping("listItem")
    public ResponseData<List<AppointmentItemVo>> listItem() {

        Long userId = LoginUserHolder.getLoginUser().getUserId();
        List<AppointmentItemVo> result = viewAppointmentService.listItemByUserId(userId);
        return ResponseData.ok(result);
    }

    @GetMapping("getDetailById")
    @Operation(summary = "根据ID查询预约详情信息")
    public ResponseData<AppointmentDetailVo> getDetailById(Long id) {

        AppointmentDetailVo appointmentDetailVo = viewAppointmentService.getDetailById(id);
        return ResponseData.ok(appointmentDetailVo);
    }

}

