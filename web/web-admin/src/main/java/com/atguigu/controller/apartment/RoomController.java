package com.atguigu.controller.apartment;

import com.atguigu.params.room.RoomGetByIdParam;
import com.atguigu.params.room.RoomListByApartmentIdParam;
import com.atguigu.params.room.RoomPageItemParam;
import com.atguigu.params.room.RoomRemoveByIdParam;
import com.atguigu.params.room.RoomSaveOrUpdateParam;
import com.atguigu.params.room.RoomUpdateStatusByIdParam;
import com.atguigu.result.ResponseData;
import com.atguigu.service.RoomInfoService;
import com.atguigu.vo.room.RoomPageVo;
import com.atguigu.vo.room.RoomVo;
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
 * @Description: 房间管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/10
 **/
@Tag(name = "房间管理", description = "房间管理")
@RestController
@RequestMapping("/admin/room")
@RequiredArgsConstructor
@Slf4j
public class RoomController {

    /**
     * 房间信息Service.
     */
    private final RoomInfoService roomService;

    @Operation(summary = "保存或更新房间信息")
    @PostMapping("/saveOrUpdate")
    public ResponseData<Void> roomSaveOrUpdate(
            @RequestBody @Validated RoomSaveOrUpdateParam params) {

        log.info("保存或更新房间信息, params: {}", params);
        roomService.roomSaveOrUpdate(params);
        return ResponseData.ok();
    }

    @Operation(summary = "根据条件分页查询房间列表")
    @PostMapping("/pageItem")
    public ResponseData<IPage<RoomPageVo>> roomPageItem(
            @RequestBody @Validated RoomPageItemParam params) {

        log.info("根据条件分页查询房间列表, params: {}", params);
        return ResponseData.ok(roomService.roomPageItem(params));
    }

    @Operation(summary = "根据id获取房间详细信息")
    @PostMapping("/getDetailById")
    public ResponseData<RoomVo> roomGetDetailById(
            @RequestBody @Validated RoomGetByIdParam params) {

        log.info("根据id获取房间详细信息, params: {}", params);
        roomService.roomGetDetailById(params);
        return ResponseData.ok();
    }

    @Operation(summary = "根据id删除房间")
    @PostMapping("/removeById")
    public ResponseData<Void> roomRemoveById(@RequestBody @Validated RoomRemoveByIdParam params) {

        log.info("根据id删除房间, params: {}", params);
        roomService.roomRemoveById(params);
        return ResponseData.ok();
    }

    @Operation(summary = "根据id更新房间发布状态")
    @PostMapping("/updateReleaseStatusById")
    public ResponseData<Void> updateReleaseStatusById(
            @RequestBody @Validated RoomUpdateStatusByIdParam params) {

        log.info("根据id更新房间发布状态, params: {}", params);
        roomService.updateReleaseStatusById(params);
        return ResponseData.ok();
    }

    @Operation(summary = "根据公寓id查询房间列表")
    @PostMapping("/listBasicByApartmentId")
    public ResponseData<Void> listBasicByApartmentId(
            @RequestBody @Validated RoomListByApartmentIdParam params) {

        log.info("根据公寓id查询房间列表, params: {}", params);
        roomService.listBasicByApartmentId(params);
        return ResponseData.ok();
    }
}
