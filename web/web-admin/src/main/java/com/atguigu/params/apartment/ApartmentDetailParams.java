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
@Schema(name = "根据ID查询公寓详情参数", description = "根据ID查询公寓详情参数")
public class ApartmentDetailParams extends BaseParams {
}
