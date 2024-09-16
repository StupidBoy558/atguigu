package com.atguigu.params.leaseTerm;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/16
 **/

@Tag(name = "LeaseTermSaveParam", description = "租期管理新增请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaseTermSaveParam {

    @NotNull(message = "租期月数不能为空")
    @Schema(description = "租期月数")
    private Integer monthCount;

    @NotBlank(message = "租期单位不能为空")
    @Schema(description = "租期单位:月")
    private String unit;

}
