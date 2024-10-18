package com.atguigu.mapper;

import com.atguigu.entity.SystemUser;
import com.atguigu.params.system.SystemUserPageParams;
import com.atguigu.vo.system.SystemUserPageVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author wf_wj
* @description 针对表【system_user(员工信息表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:48
* @Entity com.atguigu.entity.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    /**
     * 根据用户名查询用户信息.
     * @param username 用户名
     * @return 用户信息
     */
    SystemUser selectOneByUsername(String username);

    /**
     * 分页查询用户信息.
     *
     * @param page     分页参数
     * @param pageData 查询参数
     * @return 用户信息分页列表
     */
    IPage<SystemUserPageVo> pageList(
            Page<SystemUser> page, @Param("params") SystemUserPageParams pageData);
}




