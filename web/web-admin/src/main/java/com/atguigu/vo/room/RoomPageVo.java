package com.atguigu.vo.room;

import com.atguigu.vo.BaseVo;
import com.atguigu.vo.apartment.ApartmentDetailVo;
import com.atguigu.vo.apartment.ApartmentItemVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 房间列表.
 * @Author: dansheng
 * @CreateTime: 2024/10/11
 **/
@Data
public class RoomPageVo extends BaseVo {

    /**
     * 房间id.
     */
    @Schema(description = "房间id")
    private Long id;

    /**
     * 房间的号码.
     */
    @Schema(description = "房间号")
    private String roomNumber;

    /**
     * 租金（元/月）.
     */
    @Schema(description = "租金")
    private BigDecimal rent;

    /**
     * 所属公寓id.
     */
    @Schema(description = "所属公寓id")
    private Long apartmentId;

    /**
     * 是否发布.
     */
    @Schema(description = "是否发布")
    private Integer isRelease;

    /**
     * 租约结束日期.
     */
    @Schema(description = "租约结束日期")
    private Date leaseEndDate;

    /**
     * 当前入住状态.
     */
    @Schema(description = "当前入住状态")
    private Boolean isCheckIn;

    /**
     * 公寓详细信息.
     */
    @Schema(description = "公寓详细信息")
    private ApartmentItemVo apartmentItemVo;
}
