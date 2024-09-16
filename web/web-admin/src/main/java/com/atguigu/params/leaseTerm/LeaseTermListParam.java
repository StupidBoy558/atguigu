package com.atguigu.params.leaseTerm;

import com.atguigu.params.BaseParam;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/16
 **/
@Schema(name = "LeaseTermListParam", description = "查询全部租期列表请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaseTermListParam extends BaseParam {

    @Schema(description = "租期月数")
    private Integer monthCount;

    @Schema(description = "租期单位:月")
    private String unit;

}
