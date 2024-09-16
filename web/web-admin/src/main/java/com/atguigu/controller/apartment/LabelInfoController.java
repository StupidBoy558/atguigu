package com.atguigu.controller.apartment;

import com.atguigu.entity.LabelInfo;
import com.atguigu.params.labelInfo.LabelInfoDeleteParam;
import com.atguigu.params.labelInfo.LabelInfoListParam;
import com.atguigu.params.labelInfo.LabelInfoSaveParam;
import com.atguigu.params.labelInfo.LabelInfoUpdateParam;
import com.atguigu.result.ResponseData;
import com.atguigu.service.LabelInfoService;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
@Description:标签管理接口
@Author: dansheng
@CreateTime: 2024/9/16
**/

@Slf4j
@Tag(name = "标签管理", description = "标签管理")
@RestController
@RequestMapping("/admin/label")
@RequiredArgsConstructor
public class LabelInfoController {

    private final LabelInfoService labelInfoService;

    @Operation(summary = "（根据类型）查询标签列表")
    @PostMapping("/listByTypeLabel")
    public ResponseData<List<LabelInfoListVo>> listByTypeLabel(@RequestBody @Validated LabelInfoListParam param) {

        log.info("查询标签列表请求体：{}", param);
        return ResponseData.ok(labelInfoService.listByTypeLabel(param));
    }


    @Operation(summary = "新增标签")
    @PostMapping("/addLabel")
    public ResponseData<String> addLabel(@RequestBody @Validated LabelInfoSaveParam param) {
        return ResponseData.ok(labelInfoService.addLabel(param));
    }

    @Operation(summary = "更新标签")
    @PostMapping("/updateLabel")
    public ResponseData<Boolean> updateLabel(@RequestBody @Validated LabelInfoUpdateParam param) {
        return ResponseData.ok(labelInfoService.updateLabel(param));
    }

    @Operation(summary = "删除标签")
    @PostMapping("/deleteLabel")
    public ResponseData<Boolean> deleteLabel(@RequestBody @Validated LabelInfoDeleteParam param) {
        return ResponseData.ok(labelInfoService.deleteLabel(param));
    }


}
