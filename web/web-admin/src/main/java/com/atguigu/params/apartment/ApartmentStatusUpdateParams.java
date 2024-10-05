package com.atguigu.params.apartment;

import com.atguigu.params.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Data
@Schema(name = "公寓状态更新参数")
public class ApartmentStatusUpdateParams extends BaseParams {
}
