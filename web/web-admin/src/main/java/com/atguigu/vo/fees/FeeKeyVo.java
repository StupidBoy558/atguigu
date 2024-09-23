package com.atguigu.vo.fees;

import com.atguigu.vo.BaseVo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 杂费key返回体
 * @Author: dansheng
 * @CreateTime: 2024/9/23
 **/
@Data
@Schema(name = "FeeKeyVo", description = "费用")
public class FeeKeyVo extends BaseVo {

    /**
     * id.
     */
    @JsonProperty("id")
    @Schema(description = "id")
    private Long id;

    /**
     * 付款项key.
     */
    @JsonProperty("name")
    @Schema(description = "付款项key")
    private String name;


}
