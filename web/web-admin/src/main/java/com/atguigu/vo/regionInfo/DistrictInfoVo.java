package com.atguigu.vo.regionInfo;

import com.atguigu.entity.DistrictInfo;
import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 城市信息VO
 * @Author: dansheng
 * @CreateTime: 2024/9/27
 **/
@Data
@Schema(name = "DistrictInfoVo", description = "区县信息")
public class DistrictInfoVo extends BaseVo {

    /**
     * 区县id.
     */
    @Schema(description = "区县id")
    private Integer id;

    /**
     * 区县名称.
     */
    @Schema(description = "区县名称")
    private String name;

    /**
     * 所属城市id.
     */
    @Schema(description = "所属城市id")
    private Integer cityId;

    /**
     * convert to vo.
     *
     * @param districtInfoList 区县信息列表
     * @return List<DistrictInfoVo>
     */
    public static List<DistrictInfoVo> convertToVO(
            final List<DistrictInfo> districtInfoList) {
        return districtInfoList.stream().map(entity -> {
            DistrictInfoVo vo = new DistrictInfoVo();
            BeanUtils.copyProperties(entity, vo);
            return vo;
        }).collect(Collectors.toList());

    }

}
