package com.atguigu.service;

import com.atguigu.entity.SystemUser;
import com.atguigu.params.system.SystemUserPageParams;
import com.atguigu.params.system.SystemUserRemoveByIdParams;
import com.atguigu.params.system.SystemUserSaveOrUpdateParams;
import com.atguigu.params.system.SystemUserSearchByIdParams;
import com.atguigu.params.system.SystemUserSearchByNameParams;
import com.atguigu.params.system.SystemUserUpdateStatusParams;
import com.atguigu.vo.system.SystemUserItemVo;
import com.atguigu.vo.system.SystemUserPageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wf_wj
* @description 针对表【system_user(员工信息表)】的数据库操作Service
* @createDate 2024-09-16 22:26:48
*/
public interface SystemUserService extends IService<SystemUser> {

    /**
     * 分页查询用户信息.
     *
     * @param params 查询参数
     * @return 用户信息分页列表
     */
    IPage<SystemUserPageVo> systemPageItem(SystemUserPageParams params);

    /**
     * 根据id查询后台用户信息.
     *
     * @param params 查询参数
     * @return 用户信息
     */
    SystemUserItemVo systemUserSearchById(SystemUserSearchByIdParams params);

    /**
     * 保存或更新用户信息.
     *
     * @param params
     */
    void systemUserSaveOrUpdate(SystemUserSaveOrUpdateParams params);

    /**
     * 根据用户名查询用户信息.
     *
     * @param params 查询参数
     * @return 用户信息
     */
    Boolean userNameExists(SystemUserSearchByNameParams params);

    /**
     * 根据id删除用户信息.
     *
     * @param params 查询参数
     */
    void systemUserRemoveById(SystemUserRemoveByIdParams params);

    /**
     * 根据id更新用户状态.
     *
     * @param params 查询参数
     */
    void updateStatusById(SystemUserUpdateStatusParams params);
}
