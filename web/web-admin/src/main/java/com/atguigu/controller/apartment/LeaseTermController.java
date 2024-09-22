package com.atguigu.controller.apartment;

import com.atguigu.entity.LeaseTerm;
import com.atguigu.params.leaseTerm.LeaseTermDeleteParam;
import com.atguigu.params.leaseTerm.LeaseTermListParams;
import com.atguigu.params.leaseTerm.LeaseTermSaveParam;
import com.atguigu.params.leaseTerm.LeaseTermUpdateParam;
import com.atguigu.result.ResponseData;
import com.atguigu.service.LeaseTermService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/16
 **/


@Tag(name = "租期管理", description = "租期管理")
@RequestMapping("/admin/term")
@RestController
@RequiredArgsConstructor
public class LeaseTermController {

    private final LeaseTermService leaseTermService;

    // 租期列表
    @Operation(summary = "查询全部租期列表")
    @PostMapping("/listLeaseTerm")
    public ResponseData<List<LeaseTerm>> listLeaseTerm(@RequestBody LeaseTermListParams param) {
        return ResponseData.ok(leaseTermService.listLeaseTerm(param));

    }

    // 新增租期
    @Operation(summary = "新增租期")
    @PostMapping("/addLeaseTerm")
    public ResponseData<String> addLeaseTerm(@RequestBody @Validated LeaseTermSaveParam param) {

        return ResponseData.ok(leaseTermService.addLeaseTerm(param));
    }


    // 修改租期
    @Operation(summary = "修改租期")
    @PostMapping("/updateLeaseTerm")
    public ResponseData<Boolean> updateLeaseTerm(@RequestBody @Validated LeaseTermUpdateParam param) {
        return ResponseData.ok(leaseTermService.updateLeaseTerm(param));
    }



    //  删除租期
    @Operation(summary = "删除租期")
    @PostMapping("/deleteLeaseTerm")
    public ResponseData<Boolean> deleteLeaseTerm(@RequestBody LeaseTermDeleteParam param) {

        return ResponseData.ok(leaseTermService.deleteLeaseTerm(param));
    }




}
