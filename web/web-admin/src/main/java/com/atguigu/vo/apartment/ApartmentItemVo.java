package com.atguigu.vo.apartment;

import com.atguigu.entity.ApartmentInfo;
import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description: 公寓信息VO.
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Data
@Schema(name = "公寓信息", description = "公寓信息")
public class ApartmentItemVo extends BaseVo {

    /**
     * 公寓id.
     */
    @Schema(description = "公寓ID")
    private Long id;

    /**
     * 公寓名称.
     */
    @Schema(description = "公寓名称")
    private String name;

    /**
     * 公寓介绍.
     */
    @Schema(description = "公寓介绍")
    private String introduction;

    /**
     * 所处区域id.
     */
    @Schema(description = "所在区县ID")
    private Long districtId;

    /**
     * 区域名称.
     */
    @Schema(description = "区域名称")
    private String districtName;

    /**
     * 所处城市id.
     */
    @Schema(description = "所在城市ID")
    private Long cityId;

    /**
     * 城市名称.
     */
    @Schema(description = "城市名称")
    private String cityName;

    /**
     * 所处省份id.
     */
    @Schema(description = "所在省份ID")
    private Long provinceId;

    /**
     * 省份名称.
     */
    @Schema(description = "省份名称")
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
     * 纬度.
     */
    @Schema(description = "维度")
    private String longitude;

    /**
     * 公寓前台电话.
     */
    @Schema(description = "公寓前台电话")
    private String phone;

    /**
     * 是否发布（1:发布，0:未发布）.
     */
    @Schema(description = "是否发布")
    private Integer isRelease;

    /**
     * 公寓信息vo.
     *
     * @param apartmentInfo 公寓信息
     * @return 公寓信息vo
     */
    public static ApartmentItemVo convertToVo(ApartmentInfo apartmentInfo) {
        ApartmentItemVo apartmentItemVo = new ApartmentItemVo();
        BeanUtils.copyProperties(apartmentInfo, apartmentItemVo);
        return apartmentItemVo;
    }
}
