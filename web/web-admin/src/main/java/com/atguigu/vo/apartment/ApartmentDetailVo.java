package com.atguigu.vo.apartment;

import com.atguigu.entity.ApartmentInfo;
import com.atguigu.entity.GraphInfo;
import com.atguigu.params.apartment.ImageSaveParams;
import com.atguigu.vo.BaseVo;
import com.atguigu.vo.facilityInfo.FacilityInfoListVo;
import com.atguigu.vo.fees.FeeValueListVo;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Description: TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Data
@Schema(name = "ApartmentDetailVo", description = "公寓详情VO")
public class ApartmentDetailVo extends BaseVo {

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
     * 图片列表.
     */
    @Schema(name = "graphVoList", description = "图片列表")
    private List<GraphVo> graphVoList;

    /**
     * 标签信息.
     */
    @Schema(name = "labelInfoList", description = "标签信息")
    private List<LabelInfoListVo> labelInfoList;

    /**
     * 设施信息.
     */
    @Schema(name = "facilityInfoList", description = "设施信息")
    private List<FacilityInfoListVo> facilityInfoList;

    /**
     * 费用信息.
     */
    @Schema(name = "feeValueList", description = "费用信息")
    private List<FeeValueListVo> feeValueList;

    /**
     * 转换为VO对象.
     *
     * @param apartmentInfo 公寓信息实体
     * @return VO对象
     */
    public static ApartmentDetailVo convertToVo(ApartmentInfo apartmentInfo) {
        ApartmentDetailVo detailVo = new ApartmentDetailVo();
        BeanUtils.copyProperties(apartmentInfo, detailVo);
        return detailVo;
    }

}
