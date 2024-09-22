package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.LeaseAgreement;
import com.atguigu.service.LeaseAgreementService;
import com.atguigu.mapper.LeaseAgreementMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
    implements LeaseAgreementService{

}




