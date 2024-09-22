package com.atguigu.params.facilityInfo;

import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/22
 **/
@Data
@Schema(name = "FacilityInfoPageParams", description = "设施信息分页参数类")
public class FacilityInfoPageParams extends BaseVo {

    /**
     * pageNum.
     */
    @Schema(description = "页码")
    private Integer pageNum;

    /**
     * pageSize.
     */
    @Schema(description = "每页数量")
    private Integer pageSize;

}
