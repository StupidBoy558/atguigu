package com.atguigu.params.labelInfo;

import com.atguigu.entity.LabelInfo;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:TODO @Author: dansheng @CreateTime: 2024/9/16
 */
@Schema(name = "标签更新请求体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelInfoUpdateParam {


    @Schema(description = "标签id")
    @NotNull(message = "标签id不能为空")
    private Long id;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "标签名称")
    private String name;


    public static LabelInfo convertToEntity(LabelInfoUpdateParam param) {
        LabelInfo labelInfo = new LabelInfo();
        BeanUtils.copyProperties(param, labelInfo);
        return labelInfo;
    }


}
