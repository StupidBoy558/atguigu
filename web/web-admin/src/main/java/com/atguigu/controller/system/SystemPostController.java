package com.atguigu.controller.system;

import com.atguigu.params.system.SystemPostPageParams;
import com.atguigu.params.system.SystemPostRemoveParams;
import com.atguigu.params.system.SystemPostSaveOrUdpateParams;
import com.atguigu.params.system.SystemPostSearchParams;
import com.atguigu.params.system.SystemPostUpdateStatusParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.SystemPostService;
import com.atguigu.vo.system.SystemPostListVo;
import com.atguigu.vo.system.SystemPostPageVo;
import com.atguigu.vo.system.SystemPostSearchVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * @Description: 后台用户岗位管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Tag(name = "SystemPostController", description = "岗位管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/system/post")
@Slf4j
public class SystemPostController {

    /**
     * 后台用户管理service.
     */
    private final SystemPostService systemPostService;

    @Schema(description = "分页查询岗位信息")
    @PostMapping("/page")
    public ResponseData<IPage<SystemPostPageVo>> systemPageItem(
            @RequestBody @Validated final SystemPostPageParams params) {

        log.info("分页查询岗位信息:{}", params);
        return ResponseData.ok(systemPostService.systemPageItem(params));
    }

    @Schema(description = "新增或修改岗位信息")
    @PostMapping("/saveOrUpdate")
    public ResponseData<Void> systemPostSaveOrUpdate(
            @RequestBody @Validated final SystemPostSaveOrUdpateParams params) {

        log.info("新增或修改岗位信息:{}", params);
        systemPostService.systemPostSaveOrUpdate(params);
        return ResponseData.ok();
    }

    @Schema(description = "根据id删除岗位信息")
    @PostMapping("/deleteById")
    public ResponseData<Void> removeById(
            @RequestBody @Validated final SystemPostRemoveParams params) {

        log.info("根据id删除岗位信息:{}", params);
        systemPostService.systemPostRemoveById(params);
        return ResponseData.ok();
    }

    @Schema(description = "查询所有岗位信息")
    @PostMapping("/list")
    public ResponseData<List<SystemPostListVo>> systemPostList() {

        log.info("查询所有岗位信息");
        return ResponseData.ok(systemPostService.systemPostList());
    }

    @Schema(description = "根据id查询岗位信息")
    @PostMapping("/getById")
    public ResponseData<SystemPostSearchVo> getById(
            @RequestBody @Validated final SystemPostSearchParams params) {

        log.info("根据id查询岗位信息:{}", params);
        return ResponseData.ok(systemPostService.systemPostGetById(params));
    }

    @Schema(description = "根据岗位id修改岗位状态")
    @PostMapping("/updateStatusByPostId")
    public ResponseData<Void> updateStatusByPostId(
            @RequestBody @Validated final SystemPostUpdateStatusParams params) {

        log.info("根据岗位id修改岗位状态:{}", params);
        systemPostService.updateStatusByPostId(params);
        return ResponseData.ok();
    }

}
