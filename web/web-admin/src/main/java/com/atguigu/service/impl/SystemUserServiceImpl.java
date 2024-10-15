package com.atguigu.service.impl;

import com.atguigu.params.system.SystemUserPageParams;
import com.atguigu.params.system.SystemUserRemoveByIdParams;
import com.atguigu.params.system.SystemUserSaveOrUpdateParams;
import com.atguigu.params.system.SystemUserSearchByIdParams;
import com.atguigu.params.system.SystemUserSearchByNameParams;
import com.atguigu.params.system.SystemUserUpdateStatusParams;
import com.atguigu.vo.system.SystemUserItemVo;
import com.atguigu.vo.system.SystemUserPageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.SystemUser;
import com.atguigu.service.SystemUserService;
import com.atguigu.mapper.SystemUserMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【system_user(员工信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements SystemUserService{

    /**
     * 分页查询用户信息.
     *
     * @param params 查询参数
     * @return 用户信息分页列表
     */
    @Override
    public IPage<SystemUserPageVo> systemPageItem(SystemUserPageParams params) {
        return null;
    }

    /**
     * 根据id查询后台用户信息.
     *
     * @param params 查询参数
     * @return 用户信息
     */
    @Override
    public SystemUserItemVo systemUserSearchById(SystemUserSearchByIdParams params) {

        return null;
    }

    @Override
    public void systemUserSaveOrUpdate(SystemUserSaveOrUpdateParams params) {

    }

    /**
     * 根据用户名查询用户信息.
     *
     * @param params 查询参数
     * @return 用户信息
     */
    @Override
    public Boolean userNameExists(SystemUserSearchByNameParams params) {

        return null;
    }

    @Override
    public void systemUserRemoveById(SystemUserRemoveByIdParams params) {

    }

    @Override
    public void updateStatusById(SystemUserUpdateStatusParams params) {

    }
}




