package com.atguigu.params.facilityInfo;

import com.atguigu.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Data
@Schema(name = "FacilityInfoListParams", description = "设施信息列表参数类")
public class FacilityInfoListParams extends BaseVo {

    @JsonProperty("type")
    @Schema(description = "类型（1:公寓图片,2:房间图片）")
    private String type;

}
