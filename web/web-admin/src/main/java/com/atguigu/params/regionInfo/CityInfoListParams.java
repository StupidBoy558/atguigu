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
@Schema(name = "CityInfoListParams", description = "城市信息列表参数")
public class CityInfoListParams extends BaseParams {

    /**
     * 所属省份id.
     */
    @Schema(description = "所属省份id")
    private Integer provinceId;

}
