package com.atguigu.params.regionInfo;

import com.atguigu.params.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 城市信息列表参数
 * @Author: dansheng
 * @CreateTime: 2024/9/24
 **/
@Data
@Schema(name = "DistrictInfoListParams", description = "区县信息列表参数")
public class DistrictInfoListParams extends BaseParams {

    @Schema(description = "城市id")
    private Integer cityId;
}
