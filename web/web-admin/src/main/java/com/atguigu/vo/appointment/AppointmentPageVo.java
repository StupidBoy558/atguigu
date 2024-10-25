package com.atguigu.vo.appointment;

import com.atguigu.vo.BaseVo;
import com.atguigu.vo.apartment.ApartmentItemVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 预约看房分页查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/13
 **/
@Data
public class AppointmentPageVo extends BaseVo {

    /**
     * 预约id
     */
    @Schema(description = "预约id")
    private Long id;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Long userId;

    /**
     * 用户姓名
     */
    @Schema(description = "用户姓名")
    private String name;

    /**
     * 用户手机号码
     */
    @Schema(description = "用户手机号码")
    private String phone;

    /**
     * 公寓id
     */
    @Schema(description = "公寓id")
    private Integer apartmentId;

    /**
     * 预约时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "预约时间")
    private Date appointmentTime;

    /**
     * 备注信息
     */
    @Schema(description = "备注信息")
    private String additionalInfo;

    /**
     * 预约状态（1:待看房，2:已取消，3已看房）
     */
    @Schema(description = "预约状态（1:待看房，2:已取消，3已看房）")
    private Integer appointmentStatus;

    /**
     * 预约公寓信息.
     */
    @Schema(description = "预约公寓信息")
    private ApartmentItemVo apartmentItemVo;
}
