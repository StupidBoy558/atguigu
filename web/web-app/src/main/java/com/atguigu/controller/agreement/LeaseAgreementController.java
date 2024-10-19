package com.atguigu.controller.agreement;


import com.atguigu.entity.LeaseAgreement;
import com.atguigu.enums.LeaseStatus;
import com.atguigu.pojo.vo.agreement.AgreementDetailVo;
import com.atguigu.pojo.vo.agreement.AgreementItemVo;
import com.atguigu.result.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/agreement")
@Tag(name = "租约信息")
public class LeaseAgreementController {

    @Operation(summary = "获取个人租约基本信息列表")
    @GetMapping("listItem")
    public ResponseData<List<AgreementItemVo>> listItem() {
        return ResponseData.ok();
    }

    @Operation(summary = "根据id获取租约详细信息")
    @GetMapping("getDetailById")
    public ResponseData<AgreementDetailVo> getDetailById(@RequestParam Long id) {
        return ResponseData.ok();
    }

    @Operation(summary = "根据id更新租约状态", description = "用于确认租约和提前退租")
    @PostMapping("updateStatusById")
    public ResponseData updateStatusById(@RequestParam Long id, @RequestParam LeaseStatus leaseStatus) {
        return ResponseData.ok();
    }

    @Operation(summary = "保存或更新租约", description = "用于续约")
    @PostMapping("saveOrUpdate")
    public ResponseData saveOrUpdate(@RequestBody LeaseAgreement leaseAgreement) {
        return ResponseData.ok();
    }

}
