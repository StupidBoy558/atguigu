package com.atguigu.service.impl;

import com.atguigu.entity.SystemUser;
import com.atguigu.mapper.SystemUserMapper;
import com.atguigu.service.SystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【system_user(员工信息表)】的数据库操作Service实现
* @createDate 2024-09-15 08:49:34
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements SystemUserService{

}




