package com.atguigu.params.apartment;

import com.atguigu.params.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 公寓查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/6
 **/
@Schema(name = "公寓查询参数", description = "公寓查询参数")
@Data
public class ApartmentSearchParams extends BaseParams {

    /**
     * 公寓名称.
     */
    @Schema(description = "公寓名称")
    private Long provinceId;

    /**
     * 城市ID.
     */
    @Schema(description = "城市ID")
    private Long cityId;

    /**
     * 区县ID.
     */
    @Schema(description = "区县ID")
    private Long districtId;

}
