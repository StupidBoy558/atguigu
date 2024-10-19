package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.SystemUser;
import com.atguigu.service.SystemUserService;
import com.atguigu.mapper.SystemUserMapper;
import org.springframework.stereotype.Service;

/**
 * @author wf_wj
 * @description 针对表【system_user(员工信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:35
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

}




