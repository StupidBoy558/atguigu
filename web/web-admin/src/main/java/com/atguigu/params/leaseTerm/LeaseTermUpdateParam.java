package com.atguigu.params.leaseTerm;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/16
 **/
@Schema(name = "LeaseTermUpdateParam", description = "修改租期请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaseTermUpdateParam implements Serializable {

    @NotNull(message = "租期id不能为空")
    @Schema(description = "租期id")
    private Integer id;

    @Schema(description = "租期月数")
    private Integer monthCount;

    @Schema(description = "租期单位:月")
    private String unit;


}
