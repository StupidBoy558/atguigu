package com.atguigu.controller.system;

import com.atguigu.entity.SystemUser;
import com.atguigu.params.system.SystemUserPageParams;
import com.atguigu.params.system.SystemUserSearchByIdParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.SystemUserService;
import com.atguigu.vo.system.SystemUserItemVo;
import com.atguigu.vo.system.SystemUserPageVo;
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

/**
 * @Description: 后台用户信息管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@RestController
@RequiredArgsConstructor
@Tag(name = "SystemUserController", description = "后台用户信息管理")
@RequestMapping("/admin/system/user")
@Slf4j
public class SystemUserController {

    /**
     * 后台用户管理service.
     */
    private final SystemUserService systemUserService;

    @Schema(description = "分页查询用户信息")
    @PostMapping("/page")
    public ResponseData<IPage<SystemUserPageVo>> systemPageItem(
            @RequestBody @Validated final SystemUserPageParams params) {

        log.info("分页查询用户信息:{}", params);
        return ResponseData.ok(systemUserService.systemPageItem(params));
    }

    @Schema(description = "根据id查询后台用户信息")
    @PostMapping("/getById")
    public ResponseData<SystemUserItemVo> systemUserSearchById(
            @RequestBody @Validated final SystemUserSearchByIdParams params) {

        log.info("根据id查询后台用户信息:{}", params);
        return ResponseData.ok(systemUserService.systemUserSearchById(params));

    }

}
