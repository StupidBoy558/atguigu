package com.atguigu.params.attribute;

import com.atguigu.params.BaseParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Schema(name = "AttrKeyDeleteParams", description = "删除属性key请求体")
@Data
public class AttrKeyDeleteParams extends BaseParams {

    @NotNull(message = "属性key id不能为空")
    @JsonProperty("id")
    @Schema(description = "属性key id")
    private Long id;
}
