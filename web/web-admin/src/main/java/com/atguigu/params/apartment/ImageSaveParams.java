package com.atguigu.params.apartment;

import com.atguigu.params.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 图片保存参数.
 * @Author: dansheng
 * @CreateTime: 2024/9/29
 **/
@Data
@Schema(name = "ImageSaveParams", description = "图片保存参数")
public class ImageSaveParams extends BaseParams {
    @Schema(description = "图片名称")
    private String name;

    @Schema(description = "图片URL")
    private String url;
}
