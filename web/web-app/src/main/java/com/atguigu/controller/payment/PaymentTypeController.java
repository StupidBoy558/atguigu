package com.atguigu.controller.payment;

import com.atguigu.entity.PaymentType;
import com.atguigu.entity.RoomPaymentType;
import com.atguigu.result.ResponseData;
import com.atguigu.service.PaymentTypeService;
import com.atguigu.service.RoomPaymentTypeService;
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
import java.util.stream.Collectors;

@Tag(name = "支付方式接口")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/app/payment")
public class PaymentTypeController {

    private final PaymentTypeService paymentTypeService;

    private final RoomPaymentTypeService roomPaymentTypeService;

    @Operation(summary = "根据房间id获取可选支付方式列表")
    @GetMapping("listByRoomId")
    public ResponseData<List<PaymentType>> list(@RequestParam Long id) {

        log.info("根据房间id获取可选支付方式列表, id: {}", id);
        List<PaymentType> paymentTypeList = paymentTypeService.getPaymentTypeByRoomId(id);
        return ResponseData.ok(paymentTypeList);
    }

    @Operation(summary = "获取全部支付方式列表")
    @GetMapping("list")
    public ResponseData<List<PaymentType>> list() {

        log.info("获取全部支付方式列表");
        List<PaymentType> list = paymentTypeService.list();
        return ResponseData.ok(list);
    }
}
