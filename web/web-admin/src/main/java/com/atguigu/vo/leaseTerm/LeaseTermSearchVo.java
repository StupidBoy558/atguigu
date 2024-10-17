package com.atguigu.vo.leaseTerm;

import com.atguigu.entity.LeaseTerm;
import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @Description: 租期查询VO.
 * @Author: dansheng
 * @CreateTime: 2024/9/16
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaseTermSearchVo extends BaseVo {

    /**
     * 租期id.
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

    /**
     * 租期描述.
     *
     * @param leaseTerm
     * @return
     */
    public static LeaseTermSearchVo convertToVo(LeaseTerm leaseTerm) {
        LeaseTermSearchVo leaseTermSearchVo = new LeaseTermSearchVo();
        BeanUtils.copyProperties(leaseTerm, leaseTermSearchVo);
        return leaseTermSearchVo;
    }
}
