package com.atguigu.controller.payment;

import com.atguigu.entity.PaymentType;
import com.atguigu.result.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "支付方式接口")
@RestController
@RequestMapping("/app/payment")
public class PaymentTypeController {

    @Operation(summary = "根据房间id获取可选支付方式列表")
    @GetMapping("listByRoomId")
    public ResponseData<List<PaymentType>> list(@RequestParam Long id) {
        return ResponseData.ok();
    }

    @Operation(summary = "获取全部支付方式列表")
    @GetMapping("list")
    public ResponseData<List<PaymentType>> list() {
        return ResponseData.ok();
    }
}
