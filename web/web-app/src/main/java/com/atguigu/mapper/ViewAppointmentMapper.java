package com.atguigu.mapper;

import com.atguigu.entity.ViewAppointment;
import com.atguigu.pojo.vo.appointment.AppointmentDetailVo;
import com.atguigu.pojo.vo.appointment.AppointmentItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【view_appointment(预约看房信息表)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:35
 * @Entity com.atguigu.entity.ViewAppointment
 */
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    /**
     * 查询个人预约看房列表
     *
     * @param userId 用户id
     * @return List<AppointmentItemVo>
     */
    List<AppointmentItemVo> listItemByUserId(@Param("id") Long userId);
}




