package com.atguigu.controller.region;

import com.atguigu.entity.CityInfo;
import com.atguigu.entity.DistrictInfo;
import com.atguigu.entity.ProvinceInfo;
import com.atguigu.result.ResponseData;
import com.atguigu.service.CityInfoService;
import com.atguigu.service.DistrictInfoService;
import com.atguigu.service.ProvinceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "地区信息")
@RestController
@RequestMapping("/app/region")
@Slf4j
@RequiredArgsConstructor
public class RegionController {

    private final ProvinceInfoService provinceInfoService;

    private final CityInfoService cityInfoService;

    private final DistrictInfoService districtInfoService;

    @Operation(summary = "查询省份信息列表")
    @GetMapping("province/list")
    public ResponseData<List<ProvinceInfo>> listProvince() {

        log.info("查询省份信息列表");
        List<ProvinceInfo> list = provinceInfoService.list();
        return ResponseData.ok(list);
    }

    @Operation(summary = "根据省份id查询城市信息列表")
    @GetMapping("city/listByProvinceId")
    public ResponseData<List<CityInfo>> listCityInfoByProvinceId(@RequestParam Long id) {

        log.info("根据省份id查询城市信息列表, id: {}", id);
        LambdaQueryWrapper<CityInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CityInfo::getProvinceId, id);
        List<CityInfo> list = cityInfoService.list(queryWrapper);
        return ResponseData.ok(list);
    }

    @GetMapping("district/listByCityId")
    @Operation(summary = "根据城市id查询区县信息")
    public ResponseData<List<DistrictInfo>> listDistrictInfoByCityId(@RequestParam Long id) {

        log.info("根据城市id查询区县信息, id: {}", id);
        LambdaQueryWrapper<DistrictInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DistrictInfo::getCityId, id);
        List<DistrictInfo> list = districtInfoService.list(queryWrapper);
        return ResponseData.ok(list);
    }
}
