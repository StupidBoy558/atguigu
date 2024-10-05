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
@Schema(name = "公寓分页查询参数", description = "公寓分页查询参数")
public class ApartmentPageParams extends BaseParams {
}
