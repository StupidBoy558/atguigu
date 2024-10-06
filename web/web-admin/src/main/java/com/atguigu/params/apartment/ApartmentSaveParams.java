package com.atguigu.params.apartment;

import com.atguigu.entity.ApartmentFacility;
import com.atguigu.entity.ApartmentFeeValue;
import com.atguigu.entity.ApartmentInfo;
import com.atguigu.entity.ApartmentLabel;
import com.atguigu.params.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 公寓保存参数.
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Schema(name = "ApartmentSaveParams", description = "公寓保存参数")
@Data
public class ApartmentSaveParams extends BaseParams {

    /**
     * 公寓ID.
     */
    @Schema(description = "公寓ID")
    private Long id;

    /**
     * 公寓名称.
     */
    @Schema(description = "公寓名称")
    private String name;

    /**
     * 公寓简介.
     */
    @Schema(description = "公寓简介")
    private String introduction;

    /**
     * 公寓详细介绍.
     */
    @Schema(description = "所在区县ID")
    private Integer districtID;

    /**
     * 所在区县名称.
     */
    @Schema(description = "所在区县名称")
    private String districtName;

    /**
     * 所在城市ID.
     */
    @Schema(description = "所在城市ID")
    private Integer cityID;

    /**
     * 所在城市名称.
     */
    @Schema(description = "所在城市名称")
    private String cityName;

    /**
     * 所在省份ID.
     */
    @Schema(description = "所在省份ID")
    private Integer provinceID;

    /**
     * 所在省份名称.
     */
    @Schema(description = "所在省份名称")
    private String provinceName;

    /**
     * 详细地址.
     */
    @Schema(description = "详细地址")
    private String addressDetail;

    /**
     * 经度.
     */
    @Schema(description = "经度")
    private String latitude;

    /**
     * 维度.
     */
    @Schema(description = "维度")
    private String longitude;

    /**
     * 公寓前台电话.
     */
    @Schema(description = "公寓前台电话")
    private String phone;

    /**
     * 公寓状态.
     */
    @Schema(description = "是否发布")
    private Integer isRelease;

    /**
     * 公寓类型.
     */
    @Schema(description = "公寓配套设施列表")
    private List<Long> facilityIds;

    /**
     * 公寓图片列表.
     */
    @Schema(description = "公寓图片列表")
    private List<ImageSaveParams> imageVoList;

    /**
     * 公寓标签列表.
     */
    @Schema(description = "公寓标签列表")
    private List<Long> labelInfoIds;

    /**
     * 公寓费用值列表.
     */
    @Schema(description = "公寓费用值列表")
    private List<Long> feeValueIds;

    /**
     * 转换为实体对象.
     *
     * @param params 公寓保存参数
     * @return 实体对象
     */
    public static ApartmentInfo convertToEntity(
            final ApartmentSaveParams params) {
        ApartmentInfo entity = new ApartmentInfo();
        BeanUtils.copyProperties(params, entity,
                "facilityIds", "imageVoList", "labelInfoIds", "feeValueIds");
        return entity;
    }

    /**
     * 转换为ApartmentFacility实体对象.
     *
     * @param params 公寓保存参数
     * @return ApartmentFacility实体对象
     */
    public static List<ApartmentFacility> convertFacility(
            final ApartmentSaveParams params) {
        List<Long> facilityIds = params.getFacilityIds();
        if (CollectionUtils.isEmpty(facilityIds)) {
            return null;
        }

        return facilityIds.stream().map(facilityId -> {
            ApartmentFacility facility = new ApartmentFacility();
            facility.setApartmentId(params.getId());
            facility.setFacilityId(facilityId);
            return facility;
        }).collect(Collectors.toList());

    }

    /**
     * 转换为ApartmentLabel实体对象.
     *
     * @param params 公寓保存参数
     * @return ApartmentLabel实体对象
     */
    public static List<ApartmentLabel> convertLabel(
            final ApartmentSaveParams params) {
        List<Long> labelInfoIds = params.getLabelInfoIds();
        if (CollectionUtils.isEmpty(labelInfoIds)) {
            return null;
        }

        return labelInfoIds.stream().map(labelId -> {
            ApartmentLabel label = new ApartmentLabel();
            label.setApartmentId(params.getId());
            label.setLabelId(labelId);
            return label;
        }).collect(Collectors.toList());
    }

    /**
     * 转换为ApartmentFeeValue实体对象.
     *
     * @param params 公寓保存参数
     * @return ApartmentFeeValue实体对象
     */
    public static List<ApartmentFeeValue> convertFeeValue(
            final ApartmentSaveParams params) {
        List<Long> feeValueIds = params.getFeeValueIds();
        if (CollectionUtils.isEmpty(feeValueIds)) {
            return null;
        }

        return feeValueIds.stream().map(feeValueId -> {
            ApartmentFeeValue feeValue = new ApartmentFeeValue();
            feeValue.setApartmentId(params.getId());
            feeValue.setFeeValueId(feeValueId);
            return feeValue;
        }).collect(Collectors.toList());
    }
}
