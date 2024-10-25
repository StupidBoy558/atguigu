package com.atguigu.params.agreement;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: 根据ID删除租约信息.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(name = "AgreementRemoveByIdParams", description = "根据ID删除租约信息")
public class AgreementRemoveByIdParams extends BaseParams {

    /**
     * 租约ID.
     */
    @Schema(name = "id", description = "租约ID")
    @NotNull
    private Long id;
}
