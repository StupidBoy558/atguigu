package com.atguigu.params.system;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 根据id删除岗位信息.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Schema(description = "根据id删除岗位信息")
@Data
public class SystemPostRemoveParams extends BaseParams {

    /**
     * 岗位id.
     */
    @Schema(description = "岗位id")
    private Long id;
}
