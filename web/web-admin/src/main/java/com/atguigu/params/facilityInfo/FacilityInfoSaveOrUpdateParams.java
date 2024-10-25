package com.atguigu.params.facilityInfo;

import com.atguigu.entity.FacilityInfo;
import com.atguigu.vo.BaseParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description: saveOrUpdate查询请求体
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Data
public class FacilityInfoSaveOrUpdateParams extends BaseParams {

    /**
     * 自增逐渐.
     */
    @Schema(description = "id")
    @JsonProperty("id")
    private Long id;

    /**
     * 类型（1:公寓图片,2:房间图片）.
     */
    @Schema(description = "类型（1:公寓图片,2:房间图片）")
    @JsonProperty("type")
    private Integer type;

    /**
     * 名称.
     */
    @Schema(description = "名称")
    @JsonProperty("name")
    private String name;

    /**
     *icon.
     */
    @Schema(description = "icon")
    @JsonProperty("icon")
    private String icon;


    /**
     * convert方法, 将param参数转为实体对象
     * @param param 参数
     * @return 实体对象
     */
    public static FacilityInfo convertToEntity(final FacilityInfoSaveOrUpdateParams param) {
        if (param == null) {
            return null;
        }
        FacilityInfo facilityInfo = new FacilityInfo();
        BeanUtils.copyProperties(param, facilityInfo);
        return facilityInfo;
    }
}
