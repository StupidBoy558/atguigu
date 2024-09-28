package com.atguigu.controller.apartment;


import com.atguigu.params.facilityInfo.FacilityInfoDeleteParams;
import com.atguigu.params.facilityInfo.FacilityInfoListParams;
import com.atguigu.params.facilityInfo.FacilityInfoPageParams;
import com.atguigu.params.facilityInfo.FacilityInfoParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.FacilityInfoService;
import com.atguigu.vo.facilityInfo.FacilityInfoListVo;
import com.atguigu.vo.facilityInfo.FacilityInfoPageVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 配套信息管理相关接口.
 * @Author: dansheng
 * @CreateTime: 2024/9/21
 **/
@Tag(name = "公寓设施管理", description = "公寓设施管理")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/facility")
public class FacilityController {

    /**
     * 设施信息服务类.
     */
    private final FacilityInfoService facilityService;

    /**
     * 获取设施列表.
     * @param param 设施信息列表参数类
     * @return 设施信息列表
     */
    @Operation(summary = "获取设施列表")
    @PostMapping("/list")
    public ResponseData<List<FacilityInfoListVo>> listFacility(
            @RequestBody @Validated final FacilityInfoListParams param) {

        log.info("(根据类型)获取设施列表, param: {}", param);
        return ResponseData.ok(facilityService.listFacility(param));
    }

    /**
     * 分页获取设施列表.
     * @param param 设施信息列表参数类
     * @return 设施信息列表
     */
    @Operation(summary = "分页获取设施列表")
    @PostMapping("/page")
    public ResponseData<Page<FacilityInfoPageVo>> pageFacility(
            @RequestBody @Validated final FacilityInfoPageParams param) {

        log.info("(根据类型)获取设施列表, param: {}", param);
        return ResponseData.ok(facilityService.pageFacility(param));
    }

    /**
     * 新增或修改设施信息.
     * @param param 设施信息保存参数类
     * @return 是否成功
     */
    @Operation(summary = "新增或修改设施信息")
    @PostMapping("/saveOrUpdate")
    public ResponseData<Boolean> saveOrUpdate(
            @RequestBody @Validated final FacilityInfoParams param) {

        log.info("新增或修改设施信息, param: {}", param);
        return ResponseData.ok(facilityService.saveOrUpdateFacility(param));
    }


    @Operation(summary = "根据id删除设施信息")
    @PostMapping("/delete")
    public ResponseData<Boolean> deleteFacility(
            @RequestBody @Validated final FacilityInfoDeleteParams param) {

        log.info("删除设施信息, param: {}", param);
        return ResponseData.ok(facilityService.removeById(param.getId()));
    }


}
