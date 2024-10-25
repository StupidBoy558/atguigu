package com.atguigu.controller.apartment;

import com.atguigu.result.ResponseData;
import com.atguigu.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 文件上传管理
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@RestController
@RequestMapping("/admin/file")
@Tag(name = "文件上传管理", description = "文件上传管理")
@Slf4j
@RequiredArgsConstructor
public class FileUploadController {

    /**
     * 文件上传服务.
     */
    private final FileService fileService;

    /**
     * 文件上传至对象存储minio管理接口.
     *
     * @param file 文件
     * @return 文件路径
     */
    @Operation(summary = "文件上传")
    @PostMapping("/upload")
    public ResponseData<String> upload(
            @RequestParam("file") final MultipartFile file) throws Exception {

        log.info("文件上传");
        return ResponseData.ok(fileService.upload(file));

    }

}
