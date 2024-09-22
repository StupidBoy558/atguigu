package com.atguigu.controller.apartment;

import com.atguigu.params.paymentType.*;
import com.atguigu.result.ResponseData;

import com.atguigu.service.PaymentTypeService;
import com.atguigu.vo.paymentType.PaymentTypeListVo;
import com.atguigu.vo.paymentType.PaymentTypeSearchVo;
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
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/

@Tag(name = "支付方式管理")
@RestController
@RequestMapping("/admin/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentTypeController {

    private final PaymentTypeService paymentTypeService;

    @Operation(summary = "根据id查询支付方式")
    @PostMapping("/getPaymentTypeById")
    public ResponseData<PaymentTypeSearchVo> getPaymentTypeById(@RequestBody @Validated PaymentTypeSearchParams param) {
        log.info("根据id查询支付方式请求体：{}", param);

        return ResponseData.ok(paymentTypeService.getPaymentTypeById(param));
    }


    @Operation(summary = "查询全部支付方式列表")
    @PostMapping("/listPaymentType")
    public ResponseData<List<PaymentTypeListVo>> listPaymentType(@RequestBody @Validated PaymentTypeListParams param) {

        log.info("查询全部支付方式请求体：{}", param);

        return ResponseData.ok(paymentTypeService.listPaymentType());
    }

    @Operation(summary = "新增或修改支付方式")
    @PostMapping("/saveOrUpdatePaymentType")
    public ResponseData<Boolean> saveOrUpdatePaymentType(@RequestBody @Validated PaymentTypeSaveOrUpdateParam param) {

        log.info("新增或修改支付方式请求体：{}", param);

        return ResponseData.ok(paymentTypeService.saveOrUpdatePaymentType(param));
    }


    @Operation(summary = "保存支付方式")
    @PostMapping("/savePaymentType")
    public ResponseData<Boolean> savePaymentType(@RequestBody @Validated PaymentTypeSaveParams param) {

        log.info("保存支付方式请求体：{}", param);

        return ResponseData.ok(paymentTypeService.savePaymentType(param));
    }

    @Operation(summary = "更新支付方式")
    @PostMapping("/updatePaymentType")
    public ResponseData<Boolean> updatePaymentType(@RequestBody @Validated PaymentTypeUpdateParams param) {

        log.info("更新支付方式请求体：{}", param);

        return ResponseData.ok(paymentTypeService.updatePaymentType(param));
    }


    @Operation(summary = "根据id删除支付方式")
    @PostMapping("/deletePaymentById")
    public ResponseData<Boolean> deletePaymentById(@RequestBody @Validated PaymentTypeDeleteParams param) {
        log.info("根据id删除支付方式请求体：{}", param);

        return ResponseData.ok(paymentTypeService.deletePaymentById(param));
    }

}
