package com.atguigu.params.apartment;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Data
@Schema(name = "根据ID查询公寓详情参数", description = "根据ID查询公寓详情参数")
public class ApartmentDetailParams extends BaseParams {

    /**
     * 公寓ID.
     */
    @NotNull
    @Schema(description = "公寓ID")
    private Long id;

}
