package com.atguigu.mapper;

import com.atguigu.entity.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wf_wj
* @description 针对表【system_user(员工信息表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:48
* @Entity com.atguigu.entity.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    /**
     * 根据用户名查询用户信息.
     *
     * @param username 用户名
     * @return 用户信息
     */
    SystemUser selectOneByUsername(String username);
}




