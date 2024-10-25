package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工信息表
 * @TableName system_user
 */
@TableName(value ="system_user")
@Data
public class SystemUser implements Serializable {
    /**
     * 员工id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 备注信息
     */
    private String additionalInfo;

    /**
     * 岗位id
     */
    private Long postId;

    /**
     * 账号状态
     */
    private Integer status;

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