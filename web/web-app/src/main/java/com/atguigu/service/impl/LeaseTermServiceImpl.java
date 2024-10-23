package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.LeaseTerm;
import com.atguigu.service.LeaseTermService;
import com.atguigu.mapper.LeaseTermMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【lease_term(租期)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:35
 */
@Service
@RequiredArgsConstructor
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
        implements LeaseTermService {

    private final LeaseTermMapper leaseTermMapper;

    @Override
    public List<LeaseTerm> getLeaseTermByRoomId(Long id) {

        return leaseTermMapper.getLeaseTermByRoomId(id);
    }
}




