package com.atguigu.params.labelInfo;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
@Description:TODO
@Author: dansheng
@CreateTime: 2024/9/16
**/
@Schema(description = "按类型查询标签类型请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelInfoListParam extends BaseVo {

    @Schema(description = "类型")
    private String type;

    @Schema(description = "标签名称")
    private String name;

}
