package com.atguigu.params.labelInfo;

import com.atguigu.enums.ItemType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
@Description:TODO
@Author: dansheng
@CreateTime: 2024/9/16
**/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelInfoListParam {

    @Schema(description = "类型")
    private String type;

    @Schema(description = "标签名称")
    private String name;

}
