package com.atguigu.controller.user;

import com.atguigu.entity.UserInfo;
import com.atguigu.params.user.UserInfoPageParams;
import com.atguigu.params.user.UserUpdateStatusParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.UserInfoService;
import com.atguigu.vo.user.UserInfoPageVo;
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
 * @Description: 用户信息管理
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@RestController
@RequestMapping("/admin/user")
@Tag(name = "UserInfoController", description = "用户信息管理")
@RequiredArgsConstructor
@Slf4j
public class UserInfoController {

    /**
     * 用户信息服务.
     */
    private final UserInfoService userInfoService;

    /**
     * 分页查询用户信息.
     *
     * @param params 分页查询参数
     * @return 用户信息分页数据
     */
    @PostMapping("/page")
    @Operation(summary = "分页查询用户信息")
    public ResponseData<IPage<UserInfoPageVo>> pageUserInfo(
            @RequestBody @Validated final UserInfoPageParams params) {

        log.info("分页查询用户信息:{}", params);
        return ResponseData.ok(userInfoService.pageUserInfo(params));
    }

    /**
     * 根据用户id更新账号状态.
     *
     * @param params 用户id和状态
     * @return 更新结果
     */
    @PostMapping("/updateStatusById")
    @Operation(summary = "根据用户id更新账号状态")
    public ResponseData<Void> updateStatusById(
            @RequestBody @Validated final UserUpdateStatusParams params) {

        log.info("更新用户状态:{}", params);
        return ResponseData.ok(userInfoService.updateStatusById(params));
    }

}
