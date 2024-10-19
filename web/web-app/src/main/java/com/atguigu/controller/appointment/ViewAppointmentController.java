package com.atguigu.controller.appointment;


import com.atguigu.entity.ViewAppointment;
import com.atguigu.pojo.vo.appointment.AppointmentDetailVo;
import com.atguigu.pojo.vo.appointment.AppointmentItemVo;
import com.atguigu.result.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "看房预约信息")
@RestController
@RequestMapping("/app/appointment")
public class ViewAppointmentController {

    @Operation(summary = "保存或更新看房预约")
    @PostMapping("/saveOrUpdate")
    public ResponseData saveOrUpdate(@RequestBody ViewAppointment viewAppointment) {
        return ResponseData.ok();
    }

    @Operation(summary = "查询个人预约看房列表")
    @GetMapping("listItem")
    public ResponseData<List<AppointmentItemVo>> listItem() {
        return ResponseData.ok();
    }

    @GetMapping("getDetailById")
    @Operation(summary = "根据ID查询预约详情信息")
    public ResponseData<AppointmentDetailVo> getDetailById(Long id) {
        return ResponseData.ok();
    }

}

