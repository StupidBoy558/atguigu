package com.atguigu.params.apartment;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: 删除公寓信息参数.
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Data
@Schema(name = "ApartmentRemoveParams", description = "删除公寓信息参数")
public class ApartmentRemoveParams extends BaseParams {

    /**
     * 公寓信息ID.
     */
    @NotNull
    @Schema(name = "id", description = "公寓信息ID")
    private Long id;
}
