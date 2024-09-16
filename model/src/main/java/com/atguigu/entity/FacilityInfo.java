package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 配套信息表
 * @TableName facility_info
 */
@TableName(value ="facility_info")
@Data
public class FacilityInfo implements Serializable {
    /**
     * 自增逐渐
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 类型（1:公寓图片,2:房间图片）
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    /**
     * 
     */
    private String icon;

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