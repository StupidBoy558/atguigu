package com.atguigu.params.attribute;

import com.atguigu.entity.AttrKey;
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
@Schema(name = "AttrKeySaveOrUpdateParams", description = "新增或修改属性key请求体")
public class AttrKeySaveOrUpdateParams extends BaseParams {

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
     * type.
     * @param params 新增或更新查询请求体
     * @return AttrKey实体
     */
    public  static AttrKey convertToEntity(final AttrKeySaveOrUpdateParams params) {
        AttrKey entity = new AttrKey();
        BeanUtils.copyProperties(params, entity);
        return entity;
    }

}
