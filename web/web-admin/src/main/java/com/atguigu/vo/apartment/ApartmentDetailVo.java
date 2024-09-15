package com.atguigu.vo.apartment;



import com.atguigu.entity.ApartmentInfo;
import com.atguigu.entity.FacilityInfo;
import com.atguigu.entity.LabelInfo;
import com.atguigu.vo.fee.FeeValueVo;
import com.atguigu.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "公寓信息")
@Data
public class ApartmentDetailVo extends ApartmentInfo {

    @Schema(description = "图片列表")
    private List<GraphVo> graphVoList;

    @Schema(description = "标签列表")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "配套列表")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "杂费列表")
    private List<FeeValueVo> feeValueVoList;

}
