package com.atguigu.service;

import com.atguigu.entity.LeaseTerm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【lease_term(租期)】的数据库操作Service
 * @createDate 2024-10-19 09:50:35
 */
public interface LeaseTermService extends IService<LeaseTerm> {

    /**
     * 根据房间id查询租期.
     *
     * @param id 房间id
     * @return List<LeaseTerm> 租期列表
     */
    List<LeaseTerm> getLeaseTermByRoomId(Long id);
}
