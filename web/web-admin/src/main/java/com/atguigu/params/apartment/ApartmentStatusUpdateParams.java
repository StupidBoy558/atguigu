package com.atguigu.params.apartment;

import com.atguigu.enums.ReleaseStatus;
import com.atguigu.vo.BaseParams;
import com.baomidou.mybatisplus.annotation.EnumValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Description: TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Data
@Schema(name = "公寓状态更新参数")
public class ApartmentStatusUpdateParams extends BaseParams {

    /**
     * 公寓ID.
     */
    @NotNull
    @Schema(description = "公寓ID")
    private long id;

    /**
     * 公寓状态.
     */
    @EnumValue
    @Schema(description = "公寓状态")
    private ReleaseStatus status;
}
