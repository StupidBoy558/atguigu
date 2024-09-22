package com.atguigu.params.leaseTerm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/16
 **/
@Schema(name = "LeaseTermListParams", description = "查询全部租期列表请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaseTermListParams implements Serializable {

    @Schema(description = "租期月数")
    private Integer monthCount;

    @Schema(description = "租期单位:月")
    private String unit;

}
