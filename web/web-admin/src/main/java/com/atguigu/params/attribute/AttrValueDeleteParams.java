package com.atguigu.params.attribute;

import com.atguigu.vo.BaseParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Data
@Schema(name = "AttrValueDeleteParams", description = "删除属性值请求体")
public class AttrValueDeleteParams extends BaseParams {

    @NotNull(message = "属性值id不能为空")
    @JsonProperty("id")
    @Schema(description = "属性值id")
    private Long id;
}
