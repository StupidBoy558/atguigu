package com.atguigu.params.system;

import com.atguigu.entity.SystemPost;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Description: 新增或修改岗位信息.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Data
@Schema(description = "新增或修改岗位信息")
public class SystemPostSaveOrUdpateParams extends BaseParams {

    /**
     * 岗位ID
     */
    @Schema(description = "岗位ID")
    private Long id;

    /**
     * 岗位编码
     */
    @Schema(description = "岗位编码")
    private String code;

    /**
     * 岗位名称
     */
    @Schema(description = "岗位名称")
    private String name;

    /**
     * 描述
     */
    @Schema(description = "描述")
    private String description;

    /**
     * 状态（1正常 0停用）
     */
    @Schema(description = "状态（1正常 0停用）")
    private Integer status;

    /**
     * 转换为实体类
     *
     * @param params 新增或修改岗位信息参数
     * @return SystemPost
     */
    public static SystemPost convertToEntity(final SystemPostSaveOrUdpateParams params) {
        SystemPost systemPost = new SystemPost();
        BeanUtils.copyProperties(params, systemPost);
        return systemPost;
    }
}
