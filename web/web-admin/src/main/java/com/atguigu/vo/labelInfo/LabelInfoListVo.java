package com.atguigu.vo.labelInfo;

import com.atguigu.enums.ItemType;
import com.atguigu.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 标签信息列表响应体.
 * @Author: dansheng
 * @CreateTime: 2024/9/16
 */
@Schema(description = "标签信息列表响应体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelInfoListVo extends BaseVo {

    /**
     * 标签ID.
     */
    @Schema(description = "标签ID")
    private Long id;

    /**
     * 类型.
     */
    @Schema(description = "类型")
    @JsonProperty("type")
    private ItemType type;

    /**
     * 标签名称.
     */
    @Schema(description = "标签名称")
    private String name;

}
