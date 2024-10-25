package com.atguigu.controller.agreement;


import com.atguigu.entity.LeaseAgreement;
import com.atguigu.enums.LeaseStatus;
import com.atguigu.login.LoginUserHolder;
import com.atguigu.pojo.vo.agreement.AgreementDetailVo;
import com.atguigu.pojo.vo.agreement.AgreementItemVo;
import com.atguigu.result.ResponseData;
import com.atguigu.service.LeaseAgreementService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/agreement")
@Tag(name = "租约信息")
@Slf4j
@RequiredArgsConstructor
public class LeaseAgreementController {

    private final LeaseAgreementService leaseAgreementService;

    @Operation(summary = "获取个人租约基本信息列表")
    @GetMapping("listItem")
    public ResponseData<List<AgreementItemVo>> listItem() {

        log.info("获取个人租约基本信息列表");
        String username = LoginUserHolder.getLoginUser().getUsername();
        return ResponseData.ok(leaseAgreementService.ListItemByPhone(username));
    }

    @Operation(summary = "根据id获取租约详细信息")
    @GetMapping("getDetailById")
    public ResponseData<AgreementDetailVo> getDetailById(@RequestParam Long id) {

        log.info("根据id获取租约详细信息");
        return ResponseData.ok(leaseAgreementService.getDetailById(id));
    }

    @Operation(summary = "根据id更新租约状态", description = "用于确认租约和提前退租")
    @PostMapping("updateStatusById")
    public ResponseData updateStatusById(@RequestParam Long id, @RequestParam LeaseStatus leaseStatus) {

        LambdaUpdateWrapper<LeaseAgreement> agreementQueryWrapper = new LambdaUpdateWrapper<>();
        agreementQueryWrapper.eq(LeaseAgreement::getId, id)
                .set(LeaseAgreement::getStatus, leaseStatus);
        leaseAgreementService.update(agreementQueryWrapper);
        return ResponseData.ok();
    }

    @Operation(summary = "保存或更新租约", description = "用于续约")
    @PostMapping("saveOrUpdate")
    public ResponseData saveOrUpdate(@RequestBody LeaseAgreement leaseAgreement) {

        leaseAgreementService.saveOrUpdate(leaseAgreement);
        return ResponseData.ok();
    }

}
