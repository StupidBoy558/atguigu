package com.atguigu.vo.system;

import com.atguigu.entity.SystemPost;
import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description: 岗位列表查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "岗位列表查询参数")
public class SystemPostSearchVo extends BaseVo {
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

    /**
     * 转换为实体类.
     *
     * @param systemPost 岗位信息
     * @return 岗位信息
     */
    public static SystemPostSearchVo convertToVo(final SystemPost systemPost) {
        if (systemPost == null) {
            return null;
        }
        SystemPostSearchVo systemPostSearchVo = new SystemPostSearchVo();
        BeanUtils.copyProperties(systemPost, systemPostSearchVo);
        return systemPostSearchVo;
    }
}
