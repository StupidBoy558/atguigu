package com.atguigu.params.regionInfo;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 城市信息列表参数
 * @Author: dansheng
 * @CreateTime: 2024/9/24
 **/
@EqualsAndHashCode(callSuper = false)
@Data
@Schema(name = "DistrictInfoListParams", description = "区县信息列表参数")
public class DistrictInfoListParams extends BaseParams {

    @Schema(description = "城市id")
    private Integer cityId;
}
