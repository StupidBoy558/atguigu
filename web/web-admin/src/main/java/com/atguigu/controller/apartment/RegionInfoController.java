package com.atguigu.controller.apartment;


import com.atguigu.params.regionInfo.CityInfoListParams;
import com.atguigu.params.regionInfo.DistrictInfoListParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.CityInfoService;
import com.atguigu.service.DistrictInfoService;
import com.atguigu.service.ProvinceInfoService;
import com.atguigu.vo.regionInfo.CityInfoVo;
import com.atguigu.vo.regionInfo.DistrictInfoVo;
import com.atguigu.vo.regionInfo.ProvinceInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 地区信息管理接口
 * @Author: dansheng
 * @CreateTime: 2024/9/24
 **/
@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "地区信息管理", description = "地区信息管理")
@RequestMapping("/admin/region")
public class RegionInfoController {

    /**
     * 省份信息服务.
     */
    private final ProvinceInfoService provinceInfoService;

    /**
     * 城市信息服务.
     */
    private final CityInfoService cityInfoService;

    /**
     * 区县信息服务.
     */
    private final DistrictInfoService districtInfoService;

    /**
     * 查询省份信息列表.
     *
     * @return 省份信息列表
     */
    @Operation(summary = "查询省份信息列表")
    @GetMapping("province/list")
    public ResponseData<List<ProvinceInfoVo>> listProvince() {

        log.info("Request received for listProvince");
        return ResponseData.ok(provinceInfoService.listProvince());
    }

    /**
     * 根据省份id查询城市信息列表.
     *
     * @param params 省份id
     * @return 城市信息列表
     */
    @Operation(summary = "根据省份id查询城市信息列表")
    @PostMapping("city/listByProvinceId")
    public ResponseData<List<CityInfoVo>> listCityInfoByProvinceId(
            @RequestBody @Validated final CityInfoListParams params) {

        log.info("Request received for listCityInfoByProvinceId: {}", params);
        return ResponseData.ok(cityInfoService.listCityInfo(params));
    }

    /**
     * 根据城市id查询区县信息列表.
     *
     * @param params 城市id
     * @return 区县信息列表
     */
    @PostMapping("district/listByCityId")
    @Operation(summary = "根据城市id查询区县信息列表")
    public ResponseData<List<DistrictInfoVo>> listDistrictInfoByCityId(
            @RequestBody @Validated final DistrictInfoListParams params) {

        log.info("Request received for listDistrictInfoByCityId: {}", params);
        return ResponseData.ok(districtInfoService.listDistrictInfo(params));
    }

}
