package com.atguigu.params.apartment;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: 公寓分页查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Data
@Schema(name = "公寓分页查询参数", description = "公寓分页查询参数")
public class ApartmentPageParams extends BaseParams {

    @NotNull
    @Schema(description = "当前页")
    private Long current;

    @NotNull
    @Schema(description = "每页显示条数")
    private Long size;

    @Schema(description = "查询参数")
    private ApartmentSearchParams queryParams;

}
