package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 公寓&配套关联表.
 * * @TableName("apartment_facility")
 */
@TableName(value = "apartment_facility")
@Data
public class ApartmentFacility implements Serializable {
    /**
     * 主键id.
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 公寓id.
     */
    private Long apartmentId;

    /**
     * 设施id.
     */
    private Long facilityId;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

    /**
     * 是否删除.
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
