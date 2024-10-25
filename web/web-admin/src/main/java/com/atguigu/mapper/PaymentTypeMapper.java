package com.atguigu.mapper;

import com.atguigu.entity.PaymentType;
import com.atguigu.vo.paymentType.PaymentTypeListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【payment_type(支付方式表)】的数据库操作Mapper
* @createDate 2024-09-15 08:49:34
* @Entity com.atguigu.entity.PaymentType
*/
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

    /**
     * 根据房间id查询支付方式列表.
     *
     * @param roomId 房间id
     * @return 支付方式列表
     */
    List<PaymentTypeListVo> listByRoomId(@Param("id") Long roomId);
}




