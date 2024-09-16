package com.atguigu.params.labelInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description:TODO @Author: dansheng @CreateTime: 2024/9/16
 */
@Schema(name = "LabelInfoDeleteParam", description = "删除标签请求体")
@Data
public class LabelInfoDeleteParam {

    @NotNull(message = "标签id不能为空")
    @Schema(description = "标签id")
    private Long id;


}
