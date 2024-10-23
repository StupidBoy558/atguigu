package com.atguigu.controller.history;

import com.atguigu.login.LoginUserHolder;
import com.atguigu.pojo.vo.history.HistoryItemVo;
import com.atguigu.result.ResponseData;
import com.atguigu.service.BrowsingHistoryService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "浏览历史管理")
@RequestMapping("/app/history")
@RequiredArgsConstructor
public class BrowsingHistoryController {

    private final BrowsingHistoryService browsingHistoryService;

    @Operation(summary = "获取浏览历史")
    @GetMapping("pageItem")
    private ResponseData<IPage<HistoryItemVo>> page(@RequestParam long current, @RequestParam long size) {

        Page<HistoryItemVo> page = new Page<>(current, size);
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        IPage<HistoryItemVo> result = browsingHistoryService.pageItem(page, userId);
        return ResponseData.ok(result);
    }
}
