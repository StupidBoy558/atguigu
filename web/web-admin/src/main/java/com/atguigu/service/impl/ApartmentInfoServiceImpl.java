package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.ApartmentInfo;
import com.atguigu.service.ApartmentInfoService;
import com.atguigu.mapper.ApartmentInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
    implements ApartmentInfoService{

}




