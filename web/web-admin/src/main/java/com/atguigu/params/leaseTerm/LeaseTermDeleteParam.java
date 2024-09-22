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
@Schema(name = "LeaseTermDeleteParam", description = "租期删除请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaseTermDeleteParam implements Serializable {

    @NotNull(message = "租期id不能为空")
    @Schema(description = "租期id")
    private Integer id;

}
