package com.atguigu.controller.login;

import com.atguigu.login.LoginUserHolder;
import com.atguigu.params.login.LoginParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.LoginService;
import com.atguigu.vo.login.CaptchaVo;
import com.atguigu.vo.system.SystemUserInfoVo;
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

/**
 * @Description: 后台管理系统登录管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/15
 **/
@Tag(name = "后台管理系统登录管理")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin")
public class LoginController {

    /**
     * 登录服务.
     */
    private final LoginService loginService;

    /**
     * 获取验证码.
     *
     * @return 验证码.
     */
    @Operation(summary = "获取验证码")
    @GetMapping("/login/captcha")
    public ResponseData<CaptchaVo> getCaptcha() {

        log.info("获取验证码");
        CaptchaVo captcha = loginService.getCaptcha();
        if (captcha == null) {
            log.error("验证码获取失败");
            return ResponseData.fail();
        }
        log.info("验证码获取成功: {}", captcha);
        return ResponseData.ok(captcha);
    }

    @Operation(summary = "登录")
    @PostMapping("/login")
    public ResponseData<String> login(
            @RequestBody @Validated final LoginParams params) {

        log.info("用户登录:{}", params);
        return ResponseData.ok(loginService.login(params));
    }

    @Operation(summary = "获取登陆用户个人信息")
    @GetMapping("info")
    public ResponseData<SystemUserInfoVo> info() {
        SystemUserInfoVo userInfo =
                loginService.getLoginUserInfo(LoginUserHolder.getLoginUser().getUserId());
        return ResponseData.ok(userInfo);
    }

}
