package com.atguigu.vo.system;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 岗位列表.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "岗位列表")
public class SystemPostListVo extends BaseVo {

    /**
     * 岗位ID.
     */
    @Schema(description = "岗位ID")
    private Long id;

    /**
     * 岗位编码.
     */
    @Schema(description = "岗位编码")
    private String code;

    /**
     * 岗位名称.
     */
    @Schema(description = "岗位名称")
    private String name;

    /**
     * 描述.
     */
    @Schema(description = "描述")
    private String description;

    /**
     * 状态（1正常 0停用）.
     */
    @Schema(description = "状态（1正常 0停用）")
    private Integer status;
}
