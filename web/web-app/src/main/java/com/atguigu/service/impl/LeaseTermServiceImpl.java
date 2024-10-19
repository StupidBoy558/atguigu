package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.LeaseTerm;
import com.atguigu.service.LeaseTermService;
import com.atguigu.mapper.LeaseTermMapper;
import org.springframework.stereotype.Service;

/**
 * @author wf_wj
 * @description 针对表【lease_term(租期)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:35
 */
@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
        implements LeaseTermService {

}




