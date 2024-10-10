package com.atguigu.vo.apartment;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 公寓信息列表.
 * @Author: dansheng
 * @CreateTime: 2024/10/10
 **/
@Data
@Schema(description = "公寓信息列表")
public class ApartmentInfoListVo extends BaseVo {
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
}
