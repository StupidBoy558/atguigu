package com.atguigu.entity;

import com.atguigu.enums.ItemType;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 图片信息表
 * @TableName graph_info
 */
@TableName(value ="graph_info")
@Data
public class GraphInfo implements Serializable {
    /**
     * 图片id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 图片所属对象类型（1:apartment,2:room）
     */
    @TableField(value = "item_type")
    private ItemType itemType;

    /**
     * 图片所有对象id
     */
    private Long itemId;

    /**
     * 图片地址
     */
    private String url;

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