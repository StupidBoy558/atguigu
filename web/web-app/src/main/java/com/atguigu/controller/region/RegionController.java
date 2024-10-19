package com.atguigu.controller.region;

import com.atguigu.entity.CityInfo;
import com.atguigu.entity.DistrictInfo;
import com.atguigu.entity.ProvinceInfo;
import com.atguigu.result.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "地区信息")
@RestController
@RequestMapping("/app/region")
public class RegionController {

    @Operation(summary = "查询省份信息列表")
    @GetMapping("province/list")
    public ResponseData<List<ProvinceInfo>> listProvince() {
        return ResponseData.ok();
    }

    @Operation(summary = "根据省份id查询城市信息列表")
    @GetMapping("city/listByProvinceId")
    public ResponseData<List<CityInfo>> listCityInfoByProvinceId(@RequestParam Long id) {
        return ResponseData.ok();
    }

    @GetMapping("district/listByCityId")
    @Operation(summary = "根据城市id查询区县信息")
    public ResponseData<List<DistrictInfo>> listDistrictInfoByCityId(@RequestParam Long id) {
        return ResponseData.ok();
    }
}
