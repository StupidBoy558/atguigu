package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName district_info
 */
@TableName(value ="district_info")
@Data
public class DistrictInfo implements Serializable {
    /**
     * 区域id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 所属城市id
     */
    private Integer cityId;

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