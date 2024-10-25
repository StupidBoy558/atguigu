package com.atguigu.service;

import com.atguigu.entity.ApartmentInfo;
import com.atguigu.pojo.vo.apartment.ApartmentDetailVo;
import com.atguigu.pojo.vo.apartment.ApartmentItemVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author wf_wj
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
 * @createDate 2024-10-19 09:50:34
 */
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    /**
     * 根据id获取公寓的详细信息.
     *
     * @param apartmentId 公寓id
     * @return ApartmentItemVo 公寓详细信息
     */
    ApartmentItemVo getItemVoById(Long apartmentId);

    /**
     * 根据id获取公寓的详细信息.
     *
     * @param id 公寓id
     * @return ApartmentDetailVo 公寓详细信息
     */
    ApartmentDetailVo getDetailById(Long id);
}
