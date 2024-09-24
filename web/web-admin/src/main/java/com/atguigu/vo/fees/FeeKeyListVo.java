package com.atguigu.vo.fees;

import com.atguigu.dto.FeeValueListDTO;
import com.atguigu.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/23
 **/
@Data
@Schema(name = "FeeKeyListVo", description = "费用key列表")
public class FeeKeyListVo extends BaseVo {

    /**
     * id.
     */
    @Schema(description = "id")
    private Long id;

    /**
     * 付款项key.
     */
    @Schema(description = "付款项name")
    private String name;

    /**
     * Value列表.
     */
    private List<FeeValueListDTO> feeValueListDTO;


}
