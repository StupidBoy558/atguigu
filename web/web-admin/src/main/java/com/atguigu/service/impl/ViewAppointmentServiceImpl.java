package com.atguigu.service.impl;

import com.atguigu.params.appointment.AppointmentPageParams;
import com.atguigu.params.appointment.AppointmentStatusUpdateParams;
import com.atguigu.vo.appointment.AppointmentPageVo;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.ViewAppointment;
import com.atguigu.service.ViewAppointmentService;
import com.atguigu.mapper.ViewAppointmentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
@RequiredArgsConstructor
@Slf4j
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {

    /**
     * ViewAppointmentMapper.
     */
    private final ViewAppointmentMapper appointmentMapper;

    /**
     * 根据id更新预约看房状态.
     *
     * @param params 预约看房状态更新参数
     */
    @Override
    public void appointmentUpdateStatusById(final AppointmentStatusUpdateParams params) {

        log.info("根据id更新预约看房状态: {}", params);
        LambdaUpdateWrapper<ViewAppointment> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ViewAppointment::getId, params.getId());
        updateWrapper.set(ViewAppointment::getAppointmentStatus, params.getStatus());
        this.update(updateWrapper);
    }

    /**
     * 分页查询预约看房信息.
     *
     * @param params 分页查询参数
     * @return 预约看房信息分页数据
     */
    @Override
    public IPage<AppointmentPageVo> appointmentPageItem(final AppointmentPageParams params) {

        log.info("分页查询预约看房信息: {}", params);
        Page<AppointmentPageVo> page = new Page<>(params.getCurrent(), params.getSize());
        return appointmentMapper.appointmentPageItem(page, params);
    }
}




