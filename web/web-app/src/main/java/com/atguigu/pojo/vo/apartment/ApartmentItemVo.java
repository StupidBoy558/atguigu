package com.atguigu.pojo.vo.apartment;


import com.atguigu.entity.ApartmentInfo;
import com.atguigu.entity.LabelInfo;
import com.atguigu.pojo.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(description = "App端公寓信息")
public class ApartmentItemVo extends ApartmentInfo {

    private List<LabelInfo> labelInfoList;

    private List<GraphVo> graphVoList;

    private BigDecimal minRent;
}
