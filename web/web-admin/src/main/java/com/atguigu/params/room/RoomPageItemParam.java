package com.atguigu.params.room;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 分页查询房间的信息请求体.
 * @Author: dansheng
 * @CreateTime: 2024/10/11
 **/
@Data
@Schema(description = "分页查询房间的信息请求体")
public class RoomPageItemParam extends BaseParams {

    /**
     * 当前页.
     */
    @Schema(description = "当前页")
    private Long currentPage;

    /**
     * 每页显示的条数.
     */
    @Schema(description = "每页显示的条数")
    private Long pageSize;

    /**
     * 省份id.
     */
    @Schema(description = "省份id")
    private Long provinceId;

    /**
     * 城市id.
     */
    @Schema(description = "城市id")
    private Long cityId;

    /**
     * 区id.
     */
    @Schema(description = "区id")
    private Long districtId;

    /**
     * 公寓id.
     */
    @Schema(description = "公寓id")
    private Long apartmentId;
}
