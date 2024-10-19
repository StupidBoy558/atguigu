package com.atguigu.controller.login;


import com.atguigu.pojo.vo.user.LoginVo;
import com.atguigu.pojo.vo.user.UserInfoVo;
import com.atguigu.result.ResponseData;
import com.atguigu.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录管理")
@RestController
@RequestMapping("/app/")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("login/getCode")
    @Operation(summary = "获取短信验证码")
    public ResponseData<Void> getCode(@RequestParam String phone) {
        loginService.getSMSCode(phone);
        return ResponseData.ok();
    }

    @PostMapping("login")
    @Operation(summary = "登录")
    public ResponseData<String> login(@RequestBody LoginVo loginVo) {
        String token = loginService.login(loginVo);
        return ResponseData.ok(token);
    }

    @GetMapping("info")
    @Operation(summary = "获取登录用户信息")
    public ResponseData<UserInfoVo> info() {
        return ResponseData.ok();
    }
}

