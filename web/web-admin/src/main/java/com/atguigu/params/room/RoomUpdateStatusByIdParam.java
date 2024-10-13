package com.atguigu.params.room;

import com.atguigu.enums.ReleaseStatus;
import com.atguigu.vo.BaseParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: 根据id更新房间-状态参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/11
 **/
@Data
public class RoomUpdateStatusByIdParam extends BaseParams {

    /**
     * 房间-id
     */
    @Schema(description = "房间id")
    @NotNull
    private Long id;

    /**
     * 房间-状态.
     */
    @Schema(description = "房间状态")
    private ReleaseStatus status;
}
