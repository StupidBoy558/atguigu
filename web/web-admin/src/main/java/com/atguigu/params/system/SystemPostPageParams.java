package com.atguigu.params.system;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 后台用户岗位管理.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "分页查询岗位信息")
public class SystemPostPageParams extends BaseParams {

    /**
     * 岗位名称.
     */
    @Schema(description = "岗位名称")
    private Long current;

    /**
     * 岗位状态.
     */
    @Schema(description = "岗位状态")
    private Long size;
}
