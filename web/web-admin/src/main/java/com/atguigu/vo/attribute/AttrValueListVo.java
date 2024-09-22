package com.atguigu.vo.attribute;

import com.atguigu.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Data
@Schema(name = "AttrValueListVo", description = "属性值列表请求体")
public class AttrValueListVo extends BaseVo {

    /**
     * 属性id.
     */
    @JsonProperty("id")
    @Schema(description = "属性id")
    private Long id;

    /**
     * 属性值名称.
     */
    @JsonProperty("name")
    @Schema(description = "属性值名称")
    private String name;

    /**
     * 属性key id.
     */
    @JsonProperty("attrKeyId")
    @Schema(description = "属性key id")
    private Long attrKeyId;

}
