package com.atguigu.params.appointment;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 预约看房分页查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/13
 **/
@Data
public class AppointmentPageParams extends BaseParams {

    /**
     * 预约公寓所在省份.
     */
    @Schema(description = "预约公寓所在省份")
    private Long provinceId;

    /**
     * 预约公寓所在城市.
     */
    @Schema(description = "预约公寓所在城市")
    private Long cityId;

    /**
     * 预约公寓所在区.
     */
    @Schema(description = "预约公寓所在区")
    private Long districtId;

    /**
     * 预约公寓id.
     */
    @Schema(description = "预约公寓id")
    private Long apartmentId;

    /**
     * 预约人姓名.
     */
    @Schema(description = "预约人姓名")
    private String name;

    /**
     * 预约人电话.
     */
    @Schema(description = "预约人电话")
    private String phone;

    /**
     * 分页查询参数current.
     */
    @Schema(description = "分页查询参数current")
    private Long current;

    /**
     * 分页查询参数size.
     */
    @Schema(description = "分页查询参数size")
    private Long size;
}
