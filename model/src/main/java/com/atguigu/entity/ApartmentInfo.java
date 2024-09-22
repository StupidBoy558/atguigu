package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 公寓信息表
 * @TableName apartment_info
 */
@TableName(value ="apartment_info")
@Data
public class ApartmentInfo implements Serializable {
    /**
     * 公寓id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 公寓名称
     */
    private String name;

    /**
     * 公寓介绍
     */
    private String introduction;

    /**
     * 所处区域id
     */
    private Long districtId;

    /**
     * 区域名称
     */
    private String districtName;

    /**
     * 所处城市id
     */
    private Long cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 所处省份id
     */
    private Long provinceId;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 经度
     */
    private String latitude;

    /**
     * 纬度
     */
    private String longitude;

    /**
     * 公寓前台电话
     */
    private String phone;

    /**
     * 是否发布（1:发布，0:未发布）
     */
    private Integer isRelease;

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