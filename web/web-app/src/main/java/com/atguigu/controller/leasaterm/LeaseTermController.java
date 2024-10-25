package com.atguigu.controller.leasaterm;

import com.atguigu.entity.LeaseTerm;
import com.atguigu.result.ResponseData;
import com.atguigu.service.LeaseTermService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/term/")
@Tag(name = "租期信息")
@RequiredArgsConstructor
public class LeaseTermController {

    private final LeaseTermService leaseTermService;

    @GetMapping("listByRoomId")
    @Operation(summary = "根据房间id获取可选获取租期列表")
    public ResponseData<List<LeaseTerm>> list(@RequestParam Long id) {

        List<LeaseTerm> result = leaseTermService.listByRoomId(id);
        return ResponseData.ok(result);
    }
}
