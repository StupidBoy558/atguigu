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
public class FacilityInfoPageVo extends BaseVo {

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
     * 将实体类转换为VO.
     * @param entityList 实体类列表
     * @return VO列表
     */
    public static List<FacilityInfoPageVo> convertToVoList(
            final List<FacilityInfo> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        return entityList.stream().map(record -> {
            FacilityInfoPageVo vo = new FacilityInfoPageVo();
            BeanUtils.copyProperties(record, vo);
            return vo;
        }).collect(Collectors.toList());
    }
}
