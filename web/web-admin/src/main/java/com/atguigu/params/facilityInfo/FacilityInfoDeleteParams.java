package com.atguigu.params.facilityInfo;

import com.atguigu.params.BaseParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Data
@Schema(name = "FacilityInfoDeleteParams", description = "设施信息删除参数类")
public class FacilityInfoDeleteParams extends BaseParams {

    @NotNull(message = "设施信息id不能为空")
    @Schema(description = "设施信息id")
    @JsonProperty("id")
    private Long id;

}
