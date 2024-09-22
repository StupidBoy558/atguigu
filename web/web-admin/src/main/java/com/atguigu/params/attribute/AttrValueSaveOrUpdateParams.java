package com.atguigu.params.attribute;

import com.atguigu.entity.AttrKey;
import com.atguigu.entity.AttrValue;
import com.atguigu.params.BaseParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Data
@Schema(name = "AttrValueSaveOrUpdateParams", description = "新增或修改属性值请求体")
public class AttrValueSaveOrUpdateParams extends BaseParams {

    /**
     * id.
     */
    @JsonProperty("id")
    @Schema(description = "属性keyid")
    private Long id;

    /**
     * name.
     */
    @NotBlank(message = "属性key名称不能为空")
    @JsonProperty("name")
    @Schema(description = "属性key名称")
    private String name;

    /**
     * attrKeyId.
     */
    @NotBlank(message = "属性keyid不能为空")
    @JsonProperty("attrKeyId")
    @Schema(description = "属性keyid")
    private Long attrKeyId;

    /**
     * type.
     * @param params 新增或更新查询请求体
     * @return AttrKey实体
     */
    public  static AttrValue convertToEntity(final AttrValueSaveOrUpdateParams params) {
        AttrValue entity = new AttrValue();
        BeanUtils.copyProperties(params, entity);
        return entity;
    }

}
