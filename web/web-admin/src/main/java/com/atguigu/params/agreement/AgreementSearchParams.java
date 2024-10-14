package com.atguigu.params.agreement;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 租赁协议查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(name = "AgreementSearchParams", description = "租赁协议查询参数")
public class AgreementSearchParams extends BaseParams {

    /**
     * 租赁协议ID.
     */
    @Schema(description = "租赁协议ID")
    private Long id;
}
