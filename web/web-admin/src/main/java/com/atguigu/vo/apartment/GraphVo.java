package com.atguigu.vo.apartment;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 图片Vo.
 * @Author: dansheng
 * @CreateTime: 2024/10/9
 **/
@Data
@Schema(name = "GraphVo", description = "图片VO")
public class GraphVo extends BaseVo {
    /**
     * 图片名称.
     */
    @Schema(description = "图片名称")
    private String name;

    /**
     * 图片URL.
     */
    @Schema(description = "图片URL")
    private String url;
}
