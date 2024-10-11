package com.atguigu.params.fees;

import com.atguigu.entity.FeeKey;
import com.atguigu.vo.BaseParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/23
 **/
@Data
@Schema(name = "FeeKeySaveOrUpdateParams", description = "保存或更新费用key")
public class FeeKeySaveOrUpdateParams extends BaseParams {

    /**
     * id.
     */
    @JsonProperty("id")
    @Schema(description = "id")
    private Long id;

    /**
     * 付款项key.
     */
    @NotBlank(message = "付款项key不能为空")
    @JsonProperty("name")
    @Schema(description = "付款项key")
    private String name;

    /**
     * 转换为实体.
     * @param params FeeKeySaveOrUpdateParams请求体
     * @return FeeKey实体
     */
    public static FeeKey convertToEntity(FeeKeySaveOrUpdateParams params) {
        FeeKey entity = new FeeKey();
        BeanUtils.copyProperties(params, entity);
        return entity;
    }

}
