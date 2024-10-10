package com.atguigu.controller.room;

import com.atguigu.result.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 房间管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/10
 **/
@Tag(name = "房间管理", description = "房间管理")
@RestController
@RequestMapping("/admin/room")
@RequiredArgsConstructor
public class RoomController {

    @Operation(summary = "保存或更新房间信息")
    @PostMapping("/saveOrUpdate")
    public ResponseData<Void> saveOrUpdate() {
        return ResponseData.ok();
    }

    @Operation(summary = "根据条件分页查询房间列表")
    @PostMapping("/pageItem")
    public ResponseData<Void> pageItem() {
        return ResponseData.ok();
    }

    @Operation(summary = "根据id获取房间详细信息")
    @PostMapping("/getDetailById")
    public ResponseData<Void> getDetailById() {
        return ResponseData.ok();
    }

    @Operation(summary = "根据id删除房间")
    @PostMapping("/removeById")
    public ResponseData<Void> removeById() {
        return ResponseData.ok();
    }

    @Operation(summary = "根据id更新房间发布状态")
    @PostMapping("/updateReleaseStatusById")
    public ResponseData<Void> updateReleaseStatusById() {
        return ResponseData.ok();
    }

    @Operation(summary = "根据公寓id查询房间列表")
    @PostMapping("/updateRecommendStatusById")
    public ResponseData<Void> listBasicByApartmentId() {
        return ResponseData.ok();
    }
}
