package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 杂项费用值表
 * @TableName fee_value
 */
@TableName(value ="fee_value")
@Data
public class FeeValue implements Serializable {
    /**
     * id.
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 费用value
     */
    private String name;

    /**
     * 收费单位
     */
    private String unit;

    /**
     * 费用所对的fee_key
     */
    private Long feeKeyId;

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