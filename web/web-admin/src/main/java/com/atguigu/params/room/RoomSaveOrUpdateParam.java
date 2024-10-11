package com.atguigu.params.room;

import com.atguigu.params.apartment.ImageSaveParams;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: 保存或更新room信息参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/11
 **/
@Data
public class RoomSaveOrUpdateParam extends BaseParams {

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
     * 房间的图片列表.
     */
    @Schema(description = "房间的图片列表")
    private List<ImageSaveParams> graphList;

    /**
     * 房间的属性值列表.
     */
    @Schema(description = "房间的属性值列表")
    private List<Long> attrValueIds;

    /**
     * 房间的设施列表.
     */
    @Schema(description = "房间的设施列表")
    private List<Long> facilityInfoIds;

    /**
     * 房间的标签列表.
     */
    @Schema(description = "房间的标签列表")
    private List<Long> labelInfoIds;

    /**
     * 房间的支付方式列表.
     */
    @Schema(description = "房间的支付方式列表")
    private List<Long> paymentTypeIds;

    /**
     * 房间的可选租期列表.
     */
    @Schema(description = "房间的可选租期列表")
    private List<Long> leaseTermIds;

}
