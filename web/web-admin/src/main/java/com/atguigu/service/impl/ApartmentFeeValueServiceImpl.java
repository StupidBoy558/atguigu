package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.ApartmentFeeValue;
import com.atguigu.service.ApartmentFeeValueService;
import com.atguigu.mapper.ApartmentFeeValueMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【apartment_fee_value(公寓&杂费关联表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class ApartmentFeeValueServiceImpl extends ServiceImpl<ApartmentFeeValueMapper, ApartmentFeeValue>
    implements ApartmentFeeValueService{

}




