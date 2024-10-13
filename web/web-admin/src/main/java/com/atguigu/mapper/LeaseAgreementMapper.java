package com.atguigu.mapper;

import com.atguigu.entity.LeaseAgreement;
import com.atguigu.vo.leaseTerm.LeaseAgreementListVo;
import com.atguigu.vo.leaseTerm.LeaseTermListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:48
* @Entity com.atguigu.entity.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    /**
     * 根据房间id查询租期列表
     *
     * @param roomId 房间id
     * @return 租期列表
     */
    List<LeaseTermListVo> listByRoomId(@Param("id") Long roomId);
}




