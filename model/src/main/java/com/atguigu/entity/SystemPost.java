package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 岗位信息表
 * @TableName system_post
 */
@TableName(value ="system_post")
@Data
public class SystemPost implements Serializable {
    /**
     * 岗位ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 岗位编码
     */
    private String code;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态（1正常 0停用）
     */
    private Integer status;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 删除标记（0:可用 1:已删除）
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}