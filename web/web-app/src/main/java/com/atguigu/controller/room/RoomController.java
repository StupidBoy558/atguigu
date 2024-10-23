package com.atguigu.controller.room;


import com.atguigu.pojo.vo.room.RoomDetailVo;
import com.atguigu.pojo.vo.room.RoomItemVo;
import com.atguigu.pojo.vo.room.RoomQueryVo;
import com.atguigu.result.ResponseData;
import com.atguigu.service.RoomInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "房间信息")
@RestController
@RequestMapping("/app/room")
@Slf4j
@RequiredArgsConstructor
public class RoomController {

    private final RoomInfoService roomInfoService;

    @Operation(summary = "分页查询房间列表")
    @GetMapping("pageItem")
    public ResponseData<IPage<RoomItemVo>> pageItem(
            @RequestParam long current, @RequestParam long size, RoomQueryVo queryVo) {

        log.info("分页查询房间列表, current={}, size={}, queryVo={}", current, size, queryVo);
        Page<RoomItemVo> page = new Page<>(current, size);
        IPage<RoomItemVo> pageList = roomInfoService.pageList(page, queryVo);
        return ResponseData.ok(pageList);
    }

    @Operation(summary = "根据id获取房间的详细信息")
    @GetMapping("getDetailById")
    public ResponseData<RoomDetailVo> getDetailById(@RequestParam Long id) {

        log.info("根据id获取房间的详细信息, id={}", id);
        RoomDetailVo result = roomInfoService.getDetailById(id);
        return ResponseData.ok(result);
    }

    @Operation(summary = "根据公寓id分页查询房间列表")
    @GetMapping("pageItemByApartmentId")
    public ResponseData<IPage<RoomItemVo>> pageItemByApartmentId(
            @RequestParam long current, @RequestParam long size, @RequestParam Long id) {

        log.info("根据公寓id分页查询房间列表, current={}, size={}, id={}", current, size, id);
        Page<RoomItemVo> page = new Page<>(current, size);
        IPage<RoomItemVo> pageList = roomInfoService.pageListByApartmentId(page, id);
        return ResponseData.ok(pageList);
    }
}
