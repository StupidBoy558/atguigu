package com.atguigu.service;

import com.atguigu.entity.ApartmentInfo;
import com.atguigu.params.apartment.ApartmentSaveParams;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
