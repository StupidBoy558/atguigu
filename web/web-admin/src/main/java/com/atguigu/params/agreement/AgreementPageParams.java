package com.atguigu.params.agreement;

import com.atguigu.vo.BaseParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 租赁协议分页查询参数.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
@Schema(name = "AgreementPageParams", description = "租赁协议分页查询参数")
@Data
public class AgreementPageParams extends BaseParams {

    /**
     * 当前页.
     */
    @Schema(description = "当前页", example = "1")
    private Long current;

    /**
     * 每页显示条数.
     */
    @Schema(description = "每页显示条数", example = "10")
    private Long size;

    /**
     * 公寓所处省份id.
     */
    @Schema(description = "公寓所处省份id")
    private Long provinceId;

    /**
     * 公寓所处城市id.
     */
    @Schema(description = "公寓所处城市id")
    private Long cityId;

    /**
     * 公寓所处区域id.
     */
    @Schema(description = "公寓所处区域id")
    private Long districtId;

    /**
     * 公寓id.
     */
    @Schema(description = "公寓id")
    private Long apartmentId;

    /**
     * 房间的号码.
     */
    @Schema(description = "房间号")
    private String roomNumber;

    /**
     * 用户姓名.
     */
    @Schema(description = "用户姓名")
    private String name;

    /**
     * 用户手机号码.
     */
    @Schema(description = "用户手机号码")
    private String phone;
}
