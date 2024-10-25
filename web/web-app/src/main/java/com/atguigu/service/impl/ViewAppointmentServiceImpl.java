package com.atguigu.service.impl;

import com.atguigu.exception.LeaseException;
import com.atguigu.pojo.vo.apartment.ApartmentItemVo;
import com.atguigu.pojo.vo.appointment.AppointmentDetailVo;
import com.atguigu.pojo.vo.appointment.AppointmentItemVo;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.service.ApartmentInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.ViewAppointment;
import com.atguigu.service.ViewAppointmentService;
import com.atguigu.mapper.ViewAppointmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:35
 */
@Service
@RequiredArgsConstructor
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {

    private final ViewAppointmentMapper viewAppointmentMapper;

    private final ApartmentInfoService apartmentInfoService;

    @Override
    public List<AppointmentItemVo> listItemByUserId(Long userId) {

        return viewAppointmentMapper.listItemByUserId(userId);
    }

    @Override
    public AppointmentDetailVo getDetailById(Long id) {

        LambdaQueryWrapper<ViewAppointment> appointmentQueryWrapper = new LambdaQueryWrapper<>();
        appointmentQueryWrapper.eq(ViewAppointment::getId, id);
        ViewAppointment viewAppointment = this.getOne(appointmentQueryWrapper);

        if (viewAppointment == null) {
            throw new LeaseException(ResultCodeEnum.DATA_ERROR.getCode(), "预约信息不存在");
        }

        ApartmentItemVo apartmentItemVo = apartmentInfoService.getItemVoById(
                viewAppointment.getApartmentId().longValue());

        AppointmentDetailVo appointmentDetailVo = new AppointmentDetailVo();
        BeanUtils.copyProperties(viewAppointment, appointmentDetailVo);
        appointmentDetailVo.setApartmentItemVo(apartmentItemVo);

        return appointmentDetailVo;
    }
}




