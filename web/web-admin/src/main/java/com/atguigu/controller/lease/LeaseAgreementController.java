package com.atguigu.controller.lease;

import com.atguigu.params.agreement.AgreementPageParams;
import com.atguigu.params.agreement.AgreementRemoveByIdParams;
import com.atguigu.params.agreement.AgreementSearchParams;
import com.atguigu.params.agreement.AgreementUpdateStatusByIdParams;
import com.atguigu.params.agreement.LeaseAgreementSaveOrUpdateParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.LeaseAgreementService;
import com.atguigu.vo.agreement.AgreementPageVo;
import com.atguigu.vo.agreement.AgreementSearchVo;
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
 * @Description: 租赁协议管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "lease-agreement", description = "租赁协议管理")
@RequestMapping("/admin/agreement")
public class LeaseAgreementController {

    /**
     * 租赁协议Service.
     */
    private final LeaseAgreementService agreementService;

    /**
     * 保存或更新租约信息.
     *
     * @param params 租约信息
     * @return 保存或更新结果
     */
    @Operation(summary = "保存或更新租约信息")
    @PostMapping("/saveOrUpdate")
    public ResponseData<Void> agreementSaveOrUpdate(
            @RequestBody @Validated final LeaseAgreementSaveOrUpdateParams params) {

        log.info("保存或更新租约信息: {}", params);
        agreementService.agreementSaveOrUpdate(params);
        return ResponseData.ok();

    }

    /**
     * 租约分页列表.
     * @param pageData 查询参数
     * @return 租约分页列表
     */
    @Operation(summary = "租约分页列表")
    @PostMapping("/page")
    public ResponseData<IPage<AgreementPageVo>> agreementPageItem(
            @RequestBody @Validated final AgreementPageParams pageData) {

        log.info("租约分页列表: {}", pageData);
        IPage<AgreementPageVo> page = agreementService.agreementPageItem(pageData);
        return ResponseData.ok(page);
    }

    /**
     * 根据ID查询租约信息.
     * @param params 查询参数
     * @return 租约信息
     */
    @Operation(summary = "根据ID查询租约信息")
    @PostMapping("/getById")
    public ResponseData<AgreementSearchVo> agreementSearchById(
            @RequestBody @Validated final AgreementSearchParams params) {

        log.info("根据ID查询租约信息: {}", params);
        return ResponseData.ok(agreementService.agreementSearchById(params));
    }

    /**
     * 根据ID删除租约信息.
     *
     * @param params 删除参数
     * @return 删除结果
     */
    @Operation(summary = "根据ID删除租约信息")
    @PostMapping("/removeById")
    public ResponseData<Void> agreementRemoveById(
            @RequestBody @Validated final AgreementRemoveByIdParams params) {

        log.info("根据ID删除租约信息: {}", params);
        agreementService.agreementRemoveById(params);
        return ResponseData.ok();
    }


    @Operation(summary = "根据ID更新租约状态")
    @PostMapping("/updateStatusById")
    public ResponseData<Void> agreementUpdateStatusById(
            @RequestBody @Validated final AgreementUpdateStatusByIdParams params) {

        log.info("根据ID更新租约状态: {}", params);
        agreementService.agreementUpdateStatusById(params);
        return ResponseData.ok();
    }

}
