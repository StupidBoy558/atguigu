package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName lease_term
 */
@TableName(value = "lease_term")
@Data
@Schema(description = "租期信息")
public class LeaseTerm extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 租约id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    @Schema(description = "租期月数")
    @TableField("month_count")
    private Integer monthCount;

    @Schema(description = "租期单位:月")
    @TableField("unit")
    private String unit;
}