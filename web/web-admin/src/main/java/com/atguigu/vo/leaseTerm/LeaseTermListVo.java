package com.atguigu.vo.leaseTerm;

import com.atguigu.vo.BaseVo;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 租期关系列表Vo.
 * @Author: dansheng
 * @CreateTime: 2024/10/13
 **/
@Data
public class LeaseTermListVo extends BaseVo {

    /**
     * 租期id
     */
    @Schema(description = "租期id")
    private Long id;

    /**
     * 租期月数.
     */
    @Schema(description = "租期月数")
    private Integer monthCount;

    /**
     * 租期单位:月.
     */
    @Schema(description = "租期单位:月")
    private String unit;
}
