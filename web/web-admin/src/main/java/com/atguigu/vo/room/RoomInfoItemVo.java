package com.atguigu.vo.room;

import com.atguigu.entity.RoomInfo;
import com.atguigu.vo.BaseVo;
import com.atguigu.vo.apartment.GraphVo;
import com.atguigu.vo.attribute.AttrValueListVo;
import com.atguigu.vo.facilityInfo.FacilityInfoListVo;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import com.atguigu.vo.leaseTerm.LeaseAgreementListVo;
import com.atguigu.vo.leaseTerm.LeaseTermListVo;
import com.atguigu.vo.paymentType.PaymentTypeListVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: 根据id获取Room详细信息
 * @Author: dansheng
 * @CreateTime: 2024/10/13
 **/
@Data
public class RoomInfoItemVo extends BaseVo {

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
     * 图片列表.
     */
    @Schema(description = "图片列表")
    private List<GraphVo> graphList;

    /**
     * 设施列表.
     */
    @Schema(description = "设施列表")
    private List<FacilityInfoListVo> facilityList;

    /**
     * 标签列表.
     */
    @Schema(description = "标签列表")
    private List<LabelInfoListVo> labelList;

    /**
     * 属性值列表.
     */
    @Schema(description = "属性值列表")
    private List<AttrValueListVo> attrValueList;

    /**
     * 支付方式列表.
     */
    @Schema(description = "支付方式列表")
    private List<PaymentTypeListVo> paymentTypeList;

    /**
     * 租期列表.
     */
    @Schema(description = "租期列表")
    private List<LeaseTermListVo> leaseTermList;

    /**
     * 将实体类转换为VO对象.
     */
    public static RoomInfoItemVo convertToVo(RoomInfo roomInfo) {
        RoomInfoItemVo roomInfoItemVo = new RoomInfoItemVo();
        BeanUtils.copyProperties(roomInfo, roomInfoItemVo);
        return roomInfoItemVo;
    }
}
