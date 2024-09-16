package com.atguigu.vo.leaseTerm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/16
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaseTermSearchVo {

    @Schema(description = "租期月数")
    private Integer monthCount;

    @Schema(description = "租期单位:月")
    private String unit;

}
