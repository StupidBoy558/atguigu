package com.atguigu.controller.apartment;


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

    /**
     * 标签信息服务.
     */
    private final LabelInfoService labelInfoService;

    /**
     * 查询标签列表.
     * @param param 查询参数
     * @return 标签列表
     */
    @Operation(summary = "（根据类型）查询标签列表")
    @PostMapping("/listByTypeLabel")
    public ResponseData<List<LabelInfoListVo>> listByTypeLabel(
            @RequestBody @Validated final LabelInfoListParam param) {

        log.info("查询标签列表请求体：{}", param);
        return ResponseData.ok(labelInfoService.listByTypeLabel(param));
    }


    /**
     * 新增标签.
     * @param param 新增标签请求体
     * @return 主键回显
     */
    @Operation(summary = "新增标签")
    @PostMapping("/addLabel")
    public ResponseData<String> addLabel(
            @RequestBody @Validated final LabelInfoSaveParam param) {
        return ResponseData.ok(labelInfoService.addLabel(param));
    }

    /**
     * 更新标签.
     * @param param 更新标签请求体
     * @return 是否更新成功
     */
    @Operation(summary = "更新标签")
    @PostMapping("/updateLabel")
    public ResponseData<Boolean> updateLabel(
            @RequestBody @Validated final LabelInfoUpdateParam param) {
        return ResponseData.ok(labelInfoService.updateLabel(param));
    }

    /**
     * 删除标签.
     * @param param 删除标签请求体
     * @return 是否删除成功
     */
    @Operation(summary = "删除标签")
    @PostMapping("/deleteLabel")
    public ResponseData<Boolean> deleteLabel(
            @RequestBody @Validated final LabelInfoDeleteParam param) {
        return ResponseData.ok(labelInfoService.deleteLabel(param));
    }


}
