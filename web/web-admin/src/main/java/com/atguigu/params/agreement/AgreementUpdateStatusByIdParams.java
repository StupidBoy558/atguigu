package com.atguigu.params.agreement;

import com.atguigu.enums.LeaseStatus;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 根据ID更新协议状态参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(name = "AgreementUpdateStatusByIdParams", description = "根据ID更新协议状态参数")
public class AgreementUpdateStatusByIdParams extends BaseParams {

    /**
     * ID.
     */
    @Schema(name = "id", description = "ID")
    private Long id;

    /**
     * 状态.
     */
    @Schema(name = "status", description = "状态")
    private LeaseStatus status;
}
