package com.atguigu.vo.regionInfo;

import com.atguigu.entity.CityInfo;
import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/27
 **/
@Data
@Schema(name = "CityInfoVo", description = "城市信息")
public class CityInfoVo extends BaseVo {

    /**
     * 城市id.
     */
    @Schema(description = "城市id")
    private Integer id;

    /**
     * 城市名称.
     */
    @Schema(description = "城市名称")
    private String name;

    /**
     * 省份id.
     */
    @Schema
    private Integer provinceId;

    /**
     * 将CityInfo转换为CityInfoVo.
     *
     * @param cityInfo CityInfo
     * @return CityInfoVo
     */
    public static List<CityInfoVo> convertToVo(final List<CityInfo> cityInfo) {
        return cityInfo.stream().map(entity -> {
            CityInfoVo vo = new CityInfoVo();
            BeanUtils.copyProperties(entity, vo);
            return vo;
        }).collect(Collectors.toList());
    }

}
