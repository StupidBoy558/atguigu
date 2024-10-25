package com.atguigu.params.room;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.servlet.tags.Param;

/**
 * @Description: 根据公寓id查询房间列表.
 * @Author: dansheng
 * @CreateTime: 2024/10/11
 **/
@Data
public class RoomListByApartmentIdParam extends Param {

    /**
     * 公寓id.
     */
    @Schema(description = "公寓id")
    @NotNull
    private Long apartmentId;
}
