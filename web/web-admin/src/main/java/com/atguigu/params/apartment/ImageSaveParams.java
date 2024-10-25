package com.atguigu.params.apartment;

import com.atguigu.entity.GraphInfo;
import com.atguigu.enums.ItemType;
import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @Description: 图片保存参数.
 * @Author: dansheng
 * @CreateTime: 2024/9/29
 **/
@Data
@Schema(name = "ImageSaveParams", description = "图片保存参数")
public class ImageSaveParams extends BaseParams {
    /**
     * 图片名称.
     */
    @Schema(description = "图片名称")
    private String name;

    /**
     * 图片URL.
     */
    @Schema(description = "图片URL")
    private String url;

    /**
     * 转换为实体对象.
     *
     * @param params 公寓信息保存参数
     * @return 图片实体对象
     */
    public static List<GraphInfo> convert(ApartmentSaveParams params) {
        List<ImageSaveParams> imageVoList = params.getImageVoList();
        if (CollectionUtils.isEmpty(imageVoList)) {
            return null;
        }

        return imageVoList.stream().map(param -> {
            GraphInfo graphInfo = new GraphInfo();
            BeanUtils.copyProperties(param, graphInfo);
            graphInfo.setItemType(ItemType.APARTMENT);
            return graphInfo;
        }).collect(Collectors.toList());
    }
}
