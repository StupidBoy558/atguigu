package com.atguigu.params.room;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: 房间列表.
 * @Author: dansheng
 * @CreateTime: 2024/10/11
 **/
@Data
public class RoomGetByIdParam extends BaseParams {

    /**
     * 房间id.
     */
    @NotNull
    @Schema(description = "房间id")
    private Long id;
}
