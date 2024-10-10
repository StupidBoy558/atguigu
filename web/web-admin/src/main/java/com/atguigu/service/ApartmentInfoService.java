package com.atguigu.service;

import com.atguigu.entity.ApartmentInfo;
import com.atguigu.params.apartment.ApartmentDetailParams;
import com.atguigu.params.apartment.ApartmentInfoListParams;
import com.atguigu.params.apartment.ApartmentPageParams;
import com.atguigu.params.apartment.ApartmentRemoveParams;
import com.atguigu.params.apartment.ApartmentSaveParams;
import com.atguigu.params.apartment.ApartmentStatusUpdateParams;
import com.atguigu.vo.apartment.ApartmentDetailVo;
import com.atguigu.vo.apartment.ApartmentInfoListVo;
import com.atguigu.vo.apartment.ApartmentItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
* @createDate 2024-09-16 22:26:48
*/
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    /**
     * 保存或更新公寓信息.
     *
     * @param params 公寓保存参数
     * @return 是否成功
     */
    String apartmentSaveOrUpdate(ApartmentSaveParams params);

    /**
     * 分页查询公寓信息.
     *
     * @param params 查询参数
     * @return
     */
    IPage<ApartmentItemVo> apartmentPageItem(ApartmentPageParams params);

    /**
     * 根据ID值获取公寓信息.
     *
     * @param params ApartmentDetailParams
     * @return 公寓详情
     */
    ApartmentDetailVo getDetailById(ApartmentDetailParams params);

    /**
     * 根据ID删除公寓信息.
     *
     * @param params 删除参数
     */
    void removeApartmentById(ApartmentRemoveParams params);

    /**
     * 根据区县ID查询公寓信息列表.
     *
     * @param params ApartmentInfoListParams
     * @return 公寓信息列表
     */
    List<ApartmentInfoListVo> listInfoByDistrictId(ApartmentInfoListParams params);

    /**
     * 根据ID更新公寓状态.
     *
     * @param params ApartmentStatusUpdateParams
     * @return 是否成功
     */
    Boolean updateReleaseStatusById(ApartmentStatusUpdateParams params);

}
