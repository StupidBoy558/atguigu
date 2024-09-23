package com.atguigu.params.fees;

import com.atguigu.params.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/23
 **/
@Data
@Schema(name = "FeeValueDeleteParams", description = "删除杂费值参数")
public class FeeValueDeleteParams extends BaseParams {
}
