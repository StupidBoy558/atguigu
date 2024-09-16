package com.atguigu.params.labelInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:TODO @Author: dansheng @CreateTime: 2024/9/16
 */
@Schema(name = "LabelInfoSaveParam", description = "新增标签请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelInfoSaveParam {

    @NotBlank(message = "类型不能为空")
    @Schema(description = "类型")
    private String type;

    @NotBlank(message = "标签名称不能为空")
    @Schema(description = "标签名称")
    private String name;

}
