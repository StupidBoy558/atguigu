package com.atguigu.params.apartment;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: 公寓信息列表查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/10
 **/
@Data
@Schema(name = "公寓信息列表查询参数")
public class ApartmentInfoListParams extends BaseParams {

    /**
     * 区县id.
     */
    @NotNull
    @Schema(description = "区县id")
    private Long districtId;
}
