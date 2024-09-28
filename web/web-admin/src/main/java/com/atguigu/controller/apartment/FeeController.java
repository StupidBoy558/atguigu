package com.atguigu.controller.apartment;

import com.atguigu.params.fees.FeeKeyDeleteParams;
import com.atguigu.params.fees.FeeKeySaveOrUpdateParams;
import com.atguigu.params.fees.FeeValueDeleteParams;
import com.atguigu.params.fees.FeeValueSaveOrUpdateParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.FeeKeyService;
import com.atguigu.service.FeeValueService;
import com.atguigu.vo.fees.FeeKeyListVo;
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
 * @Description: 费用管理.
 * @Author: dansheng
 * @CreateTime: 2024/9/23
 **/
@Slf4j
@Tag(name = "费用管理", description = "费用管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/fee")
public class FeeController {

    /**
     * 费用key服务.
     */
    private final FeeKeyService feeKeyService;

    /**
     * 费用值服务.
     */
    private final FeeValueService feeValueService;

    /**
     * 保存或更新费用key.
     * @param params 参数
     * @return 是否成功
     */
    @Operation(summary = "保存或更新费用key")
    @PostMapping("/key/saveOrUpdate")
    public ResponseData<Boolean> saveOrUpdateFeeKey(
            @RequestBody @Validated final FeeKeySaveOrUpdateParams params) {

        log.info("saveOrUpdateFeeKey params: {}", params);
        Boolean result = feeKeyService.saveOrUpdateFeeKey(params);
        if (result) {
            return ResponseData.ok();
        } else {
            return ResponseData.fail();
        }

    }

    /**
     * 保存或更新杂费值.
     * @param params 保存或更新杂费值请求体
     * @return 是否成功
     */
    @Operation(summary = "保存或更新杂费值")
    @PostMapping("/value/saveOrUpdate")
    public ResponseData<Boolean> saveOrUpdateFeeValue(
            @RequestBody @Validated final FeeValueSaveOrUpdateParams params) {

        log.info("saveOrUpdateFeeValue params: {}", params);
        Boolean result = feeValueService.saveOrUpdateFeeValue(params);
        if (result) {
            return ResponseData.ok();
        } else {
            return ResponseData.fail();
        }
    }

    /**
     * 查询全部杂费名称和杂费值列表.
     * @return 杂费名称和杂费值列表
     */
    @Operation(summary = "查询全部杂费名称和杂费值列表")
    @PostMapping("/list")
    public ResponseData<List<FeeKeyListVo>> feeInfoList() {

        log.info("feeInfoList :");
        return ResponseData.ok(feeKeyService.feeInfoList());
    }

    /**
     *  删除杂费名称.
     * @param params 删除杂费名称请求体
     * @return 是否成功
     */
    @Operation(summary = "删除杂费名称")
    @PostMapping("/key/deleteById")
    public ResponseData<Boolean> deleteFeeKeyById(
            @RequestBody @Validated final FeeKeyDeleteParams params) {

        log.info("deleteFeeKeyById params: {}", params);
        Boolean result = feeKeyService.deleteFeeKeyById(params);

        if (result) {
            return ResponseData.ok();
        } else {
            return ResponseData.fail();
        }
    }

    /**
     * 删除杂费值.
     * @param params 删除杂费值请求体
     * @return 是否成功
     */
    @Operation(summary = "删除杂费值")
    @PostMapping("/value/deleteById")
    public ResponseData<Boolean> deleteFeeValueById(
            @RequestBody @Validated final FeeValueDeleteParams params) {

        log.info("deleteFeeValueById params: {}", params);
        Boolean result = feeValueService.removeById(params.getId());
        if (result) {
            return ResponseData.ok();
        } else {
            return ResponseData.fail();
        }
    }

}
