package com.atguigu.mapper;

import com.atguigu.entity.LeaseTerm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【lease_term(租期)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:35
 * @Entity com.atguigu.entity.LeaseTerm
 */
public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {

    /**
     * 根据房间id查询租期.
     *
     * @param id 房间id
     * @return List<LeaseTerm> 租期列表
     */
    List<LeaseTerm> getLeaseTermByRoomId(@Param("id") Long id);
}




