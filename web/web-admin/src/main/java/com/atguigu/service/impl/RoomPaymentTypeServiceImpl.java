package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.RoomPaymentType;
import com.atguigu.service.RoomPaymentTypeService;
import com.atguigu.mapper.RoomPaymentTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【room_payment_type(房间&支付方式关联表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class RoomPaymentTypeServiceImpl extends ServiceImpl<RoomPaymentTypeMapper, RoomPaymentType>
    implements RoomPaymentTypeService{

}




