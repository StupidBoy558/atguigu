package com.atguigu.vo.regionInfo;

import com.atguigu.entity.ProvinceInfo;
import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 省份信息VO
 * @Author: dansheng
 * @CreateTime: 2024/9/27
 **/
@Data
@Schema(name = "ProvinceInfoVo", description = "省份信息VO")
public class ProvinceInfoVo extends BaseVo {

    /**
     * 省份id.
     */
    @Schema(description = "省份id")
    private Long id;

    /**
     * 省份名称.
     */
    @Schema(description = "省份名称")
    private String name;

    /**
     * entity convert to vo.
     *
     * @param provinceInfoEntity list of ProvinceInfo
     * @return VO对象
     */
    public static List<ProvinceInfoVo> convertToVo(
            final List<ProvinceInfo> provinceInfoEntity) {
        return provinceInfoEntity.stream().map(entity -> {
            ProvinceInfoVo vo = new ProvinceInfoVo();
            BeanUtils.copyProperties(entity, vo);
            return vo;
        }).collect(Collectors.toList());
    }

}
