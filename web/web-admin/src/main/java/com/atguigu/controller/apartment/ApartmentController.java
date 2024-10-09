package com.atguigu.controller.apartment;


import com.atguigu.params.apartment.ApartmentDetailParams;
import com.atguigu.params.apartment.ApartmentPageParams;
import com.atguigu.params.apartment.ApartmentRemoveParams;
import com.atguigu.params.apartment.ApartmentSaveParams;
import com.atguigu.params.apartment.ApartmentStatusUpdateParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.ApartmentInfoService;
import com.atguigu.vo.apartment.ApartmentDetailVo;
import com.atguigu.vo.apartment.ApartmentItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 公寓信息管理接口.
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/apartment")
@Tag(name = "公寓信息管理")
public class ApartmentController {

    /**
     * 公寓信息服务.
     */
    private final ApartmentInfoService apartmentInfoService;

    /**
     * 保存或更新公寓信息.
     *
     * @param params 公寓信息参数
     * @return 是否成功
     */
    @Operation(summary = "保存或更新公寓信息")
    @PostMapping("/saveOrUpdate")
    public ResponseData<String> apartmentSaveOrUpdate(
            @RequestBody @Validated final ApartmentSaveParams params) {

        log.info("保存或更新公寓信息, params: {}", params);
        return ResponseData.ok(
                apartmentInfoService.apartmentSaveOrUpdate(params));
    }

    /**
     * 分页查询公寓信息.
     *
     * @param params 查询参数
     * @return 公寓信息列表
     */
    @Operation(summary = "根据条件分页查询公寓列表")
    @PostMapping("/pageItem")
    public ResponseData<IPage<ApartmentItemVo>> apartmentPageItem(
            @RequestBody @Validated final ApartmentPageParams params) {

        log.info("分页查询公寓信息, params: {}", params);
        return ResponseData.ok(apartmentInfoService.apartmentPageItem(params));
    }

    /**
     * 根据ID查询公寓详情.
     * @param params 查询参数
     * @return 公寓详情
     */
    @Operation(summary = "根据ID查询公寓详情")
    @PostMapping("/getDetailById")
    public ResponseData<ApartmentDetailVo> getDetailById(
            @RequestBody @Validated final ApartmentDetailParams params) {

        log.info("根据ID查询公寓详情, params: {}", params);
        ApartmentDetailVo result = apartmentInfoService.getDetailById(params);
        return ResponseData.ok(result);
    }

    /**
     * 根据ID删除公寓信息.
     * @param params 删除参数
     * @return 是否成功
     */
    @Operation(summary = "根据ID删除公寓信息")
    @PostMapping("/removeById")
    public ResponseData<Boolean> removeById(
            @RequestBody @Validated final ApartmentRemoveParams params) {

        log.info("根据ID删除公寓信息, params: {}", params);
        return ResponseData.ok(true);
    }

    /**
     * 根据ID更新公寓发布状态.
     * @param params 更新参数
     * @return 是否成功
     */
    @Operation(summary = "根据ID更新公寓发布状态")
    @PostMapping("/updateReleaseStatusById")
    public ResponseData<Boolean> updateReleaseStatusById(
            @RequestBody @Validated final ApartmentStatusUpdateParams params) {

        log.info("根据ID更新公寓发布状态, params: {}", params);
        return ResponseData.ok(true);
    }

}
