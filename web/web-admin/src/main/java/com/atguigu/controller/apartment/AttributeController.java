package com.atguigu.controller.apartment;

import com.atguigu.params.attribute.AttrKeyDeleteParams;
import com.atguigu.params.attribute.AttrKeySaveOrUpdateParams;
import com.atguigu.params.attribute.AttrValueDeleteParams;
import com.atguigu.params.attribute.AttrValueSaveOrUpdateParams;
import com.atguigu.result.ResponseData;
import com.atguigu.service.AttrKeyService;
import com.atguigu.service.AttrValueService;
import com.atguigu.vo.attribute.AttrKeyListVo;
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
 * @Description: 房间的属性管理接口
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Slf4j
@Tag(name = "apartment/attribute", description = "房间的属性管理接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/attr")
public class AttributeController {

    /**
     * 房间的属性key管理服务.
     */
    private final AttrKeyService attrKeyService;

    /**
     * 房间的属性值管理服务.
     */
    private final AttrValueService attrValueService;

    /**
     * 保存或更新属性key.
     * @param params 属性key保存或更新参数
     * @return 是否保存或更新成功
     */
    @Operation(summary = "保存或更新属性key")
    @PostMapping("/key/saveOrUpdate")
    public ResponseData<Boolean> saveOrUpdateAttrKey(
            @RequestBody @Validated final AttrKeySaveOrUpdateParams params) {

        log.info("保存或更新属性key:{}", params);
        return ResponseData.ok(attrKeyService.saveOrUpdateAttrKey(params));
    }

    /**
     * 保存或更新属性值.
     * @param params 属性值保存或更新参数
     * @return 是否保存或更新成功
     */
    @Operation(summary = "保存或更新属性值")
    @PostMapping("/value/saveOrUpdate")
    public ResponseData<Boolean> saveOrUpdateAttrValue(
            @RequestBody @Validated final AttrValueSaveOrUpdateParams params) {

        log.info("保存或更新属性值:{}", params);
        return ResponseData.ok(attrValueService.saveOrUpdateAttrValue(params));
    }

    @Operation(summary = "获取属性key列表")
    @PostMapping("/list")
    public ResponseData<List<AttrKeyListVo>> listAttrInfo() {

        log.info("获取属性key列表");
        return ResponseData.ok(attrKeyService.listAttrInfo());
    }

    @Operation(summary = "删除属性key")
    @PostMapping("/key/deleteById")
    public ResponseData<Boolean> removeAttrKeyById(
            @RequestBody @Validated final AttrKeyDeleteParams params) {
        log.info("删除属性key:{}", params);
        Boolean removeResult = attrKeyService.removeAttrKeyById(params);
        if (removeResult) {
            return ResponseData.ok();
        } else {
            return ResponseData.fail();
        }
    }

    @Operation(summary = "删除属性值")
    @PostMapping("/value/deleteById")
    public ResponseData<Boolean> removeAttrValueById(
            @RequestBody @Validated final AttrValueDeleteParams params) {
        log.info("删除属性key value:{}", params);
        boolean removeResult = attrValueService.removeById(params.getId());
        if (removeResult) {
            return ResponseData.ok();
        } else {
            return ResponseData.fail();
        }
    }

}
