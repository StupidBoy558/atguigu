package com.atguigu.service;

import com.atguigu.entity.ViewAppointment;
import com.atguigu.params.appointment.AppointmentPageParams;
import com.atguigu.params.appointment.AppointmentStatusUpdateParams;
import com.atguigu.vo.appointment.AppointmentPageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wf_wj
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
* @createDate 2024-09-16 22:26:48
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {

    /**
     * 根据id更新预约看房状态.
     * @param params 预约看房状态更新参数
     */
    void appointmentUpdateStatusById(AppointmentStatusUpdateParams params);

    /**
     * 分页查询预约看房信息.
     *
     * @param params 分页查询参数
     * @return 预约看房信息分页数据
     */
    IPage<AppointmentPageVo> appointmentPageItem(AppointmentPageParams params);
}
