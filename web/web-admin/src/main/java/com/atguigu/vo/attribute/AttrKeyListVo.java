package com.atguigu.vo.attribute;

import com.atguigu.entity.AttrValue;
import com.atguigu.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Data
@Schema(name = "AttrKeyListVo", description = "属性key列表请求体")
public class AttrKeyListVo extends BaseVo {

    /**
     * 属性key id.
     */
    @JsonProperty("id")
    @Schema(description = "属性key id")
    private Long id;

    /**
     * 属性key名称.
     */
    @JsonProperty("name")
    @Schema(description = "属性key名称")
    private String name;

    /**
     * AttrValueListVo.
     */
    @JsonProperty("attrValueListVo")
    @Schema(description = "属性key类型")
    private List<AttrValueListVo> attrValueListVo;

}

