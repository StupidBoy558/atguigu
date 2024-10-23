package com.atguigu.controller.apartment;


import com.atguigu.pojo.vo.apartment.ApartmentDetailVo;
import com.atguigu.result.ResponseData;
import com.atguigu.service.ApartmentInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "公寓信息")
@RequestMapping("/app/apartment")
@Slf4j
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentInfoService apartmentInfoService;

    @Operation(summary = "根据id获取公寓信息")
    @GetMapping("getDetailById")
    public ResponseData<ApartmentDetailVo> getDetailById(@RequestParam Long id) {

        log.info("Apartment getDetailById id:{}", id);
        ApartmentDetailVo apartmentDetailVo = apartmentInfoService.getDetailById(id);
        return ResponseData.ok(apartmentDetailVo);
    }
}
