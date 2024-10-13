package com.atguigu.mapper;

import com.atguigu.entity.ViewAppointment;
import com.atguigu.params.appointment.AppointmentPageParams;
import com.atguigu.vo.appointment.AppointmentPageVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @author: wf_wj
 * @description: 针对表【view_appointment(预约看房信息表)】的数据库操作Mapper
 * @createDate: 2024-09-16 22:26:48
 *@Entity: com.atguigu.entity.ViewAppointmentController
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    /**
     * 分页查询预约看房信息.
     *
     * @param page   分页参数
     * @param params 分页查询参数
     * @return 预约看房信息分页数据
     */
    IPage<AppointmentPageVo> appointmentPageItem(
            @Param("page") Page<AppointmentPageVo> page, @Param("params") AppointmentPageParams params);
}




