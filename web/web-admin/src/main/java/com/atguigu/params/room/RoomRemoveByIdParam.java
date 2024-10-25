package com.atguigu.params.room;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: 根据id删除房间信息.
 * @Author: dansheng
 * @CreateTime: 2024/10/11
 **/
@Data
public class RoomRemoveByIdParam extends BaseParams {

    /**
     * 房间的id.
     */
    @NotNull
    @Schema(description = "房间的id")
    private Long id;
}
