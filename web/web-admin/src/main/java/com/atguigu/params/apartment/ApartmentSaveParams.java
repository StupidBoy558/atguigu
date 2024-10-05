package com.atguigu.params.apartment;

import com.atguigu.entity.ApartmentInfo;
import com.atguigu.params.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Description: 公寓保存参数.
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Schema(name = "ApartmentSaveParams", description = "公寓保存参数")
@Data
public class ApartmentSaveParams extends BaseParams {

    @Schema(description = "公寓ID")
    private Long id;

    @Schema(description = "公寓名称")
    private String name;

    @Schema(description = "公寓简介")
    private String introduction;

    @Schema(description = "所在区县ID")
    private Integer districtID;

    @Schema(description = "所在区县名称")
    private String districtName;

    @Schema(description = "所在城市ID")
    private Integer cityID;

    @Schema(description = "所在城市名称")
    private String cityName;

    @Schema(description = "所在省份ID")
    private Integer provinceID;

    @Schema(description = "所在省份名称")
    private String provinceName;

    @Schema(description = "详细地址")
    private String addressDetail;

    @Schema(description = "经度")
    private String latitude;

    @Schema(description = "维度")
    private String longitude;

    @Schema(description = "公寓前台电话")
    private String phone;

    @Schema(description = "是否发布")
    private Integer isRelease;

    @Schema(description = "公寓配套设施列表")
    private List<Long> facilityIds;

    @Schema(description = "公寓图片列表")
    private List<ImageSaveParams> imageVoList;

    @Schema(description = "公寓标签列表")
    private List<Long> labelInfoIds;

    @Schema(description = "公寓费用值列表")
    private List<Long> feeValueIds;

    /**
     * 转换为实体对象.
     *
     * @param params 公寓保存参数
     * @return 实体对象
     */
    public static ApartmentInfo convertToEntity(ApartmentSaveParams params) {
        ApartmentInfo entity = new ApartmentInfo();
        BeanUtils.copyProperties(params, entity, "facilityIds", "imageVoList", "labelInfoIds", "feeValueIds");
        return entity;
    }

}
