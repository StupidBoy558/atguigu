package com.atguigu.mapper;

import com.atguigu.entity.LeaseAgreement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

/**
 * @author wf_wj
 * @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:34
 * @Entity com.atguigu.entity.LeaseAgreement
 */
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    /**
     * 根据公寓id获取最小租金.
     *
     * @param id 公寓id
     * @return BigDecimal 最小租金
     */
    BigDecimal getMinRentByApartmentId(Long id);
}




