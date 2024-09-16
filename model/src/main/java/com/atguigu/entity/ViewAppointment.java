package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 预约看房信息表
 * @TableName view_appointment
 */
@TableName(value ="view_appointment")
@Data
public class ViewAppointment implements Serializable {
    /**
     * 预约id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 公寓id
     */
    private Integer apartmentId;

    /**
     * 预约时间
     */
    private Date appointmentTime;

    /**
     * 备注信息
     */
    private String additionalInfo;

    /**
     * 预约状态（1:待看房，2:已取消，3已看房）
     */
    private Integer appointmentStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}