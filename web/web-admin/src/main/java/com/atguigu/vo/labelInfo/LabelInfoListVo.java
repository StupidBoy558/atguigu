package com.atguigu.vo.labelInfo;

import com.atguigu.entity.LabelInfo;
import com.atguigu.enums.ItemType;
import com.atguigu.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:TODO @Author: dansheng @CreateTime: 2024/9/16
 */
@Schema(description = "标签信息列表响应体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LabelInfoListVo extends BaseVo {

    @Schema(description = "类型")
    @JsonProperty("type")
    private ItemType type;

    @Schema(description = "标签名称")
    private String name;

    /*
    TODO: Convert entity to vo, 可以将其抽象为base类
     */
    public static List<LabelInfoListVo> convertToVoList(List<LabelInfo> labelInfoList) {
        return labelInfoList.stream().map(labelInfo -> {
            LabelInfoListVo labelInfoListVo = new LabelInfoListVo();
            BeanUtils.copyProperties(labelInfo, labelInfoListVo);
            return labelInfoListVo;
        }).collect(Collectors.toList());
    }


}
