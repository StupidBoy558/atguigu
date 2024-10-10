package com.atguigu.entity;

import com.atguigu.enums.ItemType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "标签信息表")
@TableName(value = "label_info")
@Data
public class LabelInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键.
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 类型.
     */
    @Schema(description = "类型")
    @TableField(value = "type")
    private ItemType type;

    /**
     * 标签名称.
     */
    @Schema(description = "标签名称")
    @TableField(value = "name")
    private String name;


}