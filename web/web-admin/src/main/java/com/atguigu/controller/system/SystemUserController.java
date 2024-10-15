package com.atguigu.controller.system;

import com.atguigu.entity.SystemUser;
import com.atguigu.params.system.SystemUserPageParams;
import com.atguigu.params.system.SystemUserRemoveByIdParams;
import com.atguigu.params.system.SystemUserSaveOrUpdateParams;
import com.atguigu.params.system.SystemUserSearchByIdParams;
import com.atguigu.params.system.SystemUserSearchByNameParams;
import com.atguigu.params.system.SystemUserUpdateStatusParams;
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

    @Schema(description = "保存或更新用户信息")
    @PostMapping("/saveOrUpdate")
    public ResponseData<Void> systemUserSaveOrUpdate(
            @RequestBody @Validated final SystemUserSaveOrUpdateParams params) {

        log.info("保存或更新用户信息:{}", params);
        systemUserService.systemUserSaveOrUpdate(params);
        return ResponseData.ok();
    }

    @Schema(description = "根据用户名查询用户信息")
    @PostMapping("/isUserNameAvailable")
    public ResponseData<Boolean> userNameExists(
            @RequestBody @Validated final SystemUserSearchByNameParams params) {

        log.info("根据用户名查询用户信息:{}", params);
        return ResponseData.ok(systemUserService.userNameExists(params));
    }

    @Schema(description = "根据id删除用户信息")
    @PostMapping("/deleteById")
    public ResponseData<Void> systemUserRemoveById(
            @RequestBody @Validated final SystemUserRemoveByIdParams params) {

        log.info("根据id删除用户信息:{}", params);
        systemUserService.systemUserRemoveById(params);
        return ResponseData.ok();
    }

    @Schema(description = "根据ID修改后台用户状态")
    @PostMapping("/updateStatusByUserId")
    public ResponseData<Void> updateStatusByUserId(
            @RequestBody @Validated final SystemUserUpdateStatusParams params) {

        log.info("根据ID修改后台用户状态: {}", params);
        systemUserService.updateStatusById(params);
        return ResponseData.ok();
    }
}
