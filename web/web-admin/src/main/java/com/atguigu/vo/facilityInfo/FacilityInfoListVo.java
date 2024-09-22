package com.atguigu.vo.facilityInfo;

import com.atguigu.entity.FacilityInfo;
import com.atguigu.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "FacilityInfoListVo", description = "设施信息列表")
public class FacilityInfoListVo extends BaseVo {

    /**
     * 自增逐渐.
     */
    @Schema(description = "主键id")
    @JsonProperty("id")
    private Long id;

    /**
     * 类型（1:公寓图片,2:房间图片）.
     */
    @JsonProperty("type")
    @Schema(description = "类型（1:公寓图片,2:房间图片）")
    private Integer type;

    /**
     * 名称.
     */
    @JsonProperty("name")
    @Schema(description = "名称")
    private String name;

    /**
     * 图标.
     */
    @JsonProperty("icon")
    @Schema(description = "")
    private String icon;

    /**
     * 转换方法,将实体类List对象转换为VO对象.
     * @param facilityInfoList 实体类对象
     * @return VO对象
     */
    public static List<FacilityInfoListVo> convertToVoList(
           final List<FacilityInfo> facilityInfoList) {
        if (facilityInfoList == null) {
            return Collections.emptyList();
        }
        return facilityInfoList.stream().map(facilityInfo -> {
            FacilityInfoListVo facilityInfoListVo = new FacilityInfoListVo();
            BeanUtils.copyProperties(facilityInfo, facilityInfoListVo);
            return facilityInfoListVo;
        }).collect(Collectors.toList());
    }
}



