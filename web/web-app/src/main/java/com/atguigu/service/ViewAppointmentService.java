package com.atguigu.service;

import com.atguigu.entity.ViewAppointment;
import com.atguigu.pojo.vo.appointment.AppointmentDetailVo;
import com.atguigu.pojo.vo.appointment.AppointmentItemVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
 * @createDate 2024-10-19 09:50:35
 */
public interface ViewAppointmentService extends IService<ViewAppointment> {

    /**
     * 保存或更新看房预约.
     *
     * @param userId 用户id
     * @return AppointmentItemVo
     */
    List<AppointmentItemVo> listItemByUserId(Long userId);

    /**
     * 根据ID查询预约详情信息.
     *
     * @param id 预约id
     * @return AppointmentDetailVo
     */
    AppointmentDetailVo getDetailById(Long id);
}
