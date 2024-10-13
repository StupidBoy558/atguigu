package com.atguigu.service.impl;

import com.atguigu.params.appointment.AppointmentStatusUpdateParams;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.ViewAppointment;
import com.atguigu.service.ViewAppointmentService;
import com.atguigu.mapper.ViewAppointmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
@Slf4j
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
    implements ViewAppointmentService{

    @Override
    public void appointmentUpdateStatusById(AppointmentStatusUpdateParams params) {

        log.info("根据id更新预约看房状态: {}", params);
        LambdaUpdateWrapper<ViewAppointment> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ViewAppointment::getId, params.getId());
        updateWrapper.set(ViewAppointment::getAppointmentStatus, params.getStatus());
        this.update(updateWrapper);
    }
}




