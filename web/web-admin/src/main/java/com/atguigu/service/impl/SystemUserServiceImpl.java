package com.atguigu.service.impl;

import com.atguigu.exception.LeaseException;
import com.atguigu.params.system.SystemUserPageParams;
import com.atguigu.params.system.SystemUserRemoveByIdParams;
import com.atguigu.params.system.SystemUserSaveOrUpdateParams;
import com.atguigu.params.system.SystemUserSearchByIdParams;
import com.atguigu.params.system.SystemUserSearchByNameParams;
import com.atguigu.params.system.SystemUserUpdateStatusParams;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.vo.system.SystemUserItemVo;
import com.atguigu.vo.system.SystemUserPageVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.SystemUser;
import com.atguigu.service.SystemUserService;
import com.atguigu.mapper.SystemUserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【system_user(员工信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

    /**
     * 分页查询用户信息.
     *
     * @param pageData 查询参数
     * @return 用户信息分页列表
     */
    @Override
    public IPage<SystemUserPageVo> systemPageItem(final SystemUserPageParams pageData) {

        Page<SystemUser> page = new Page<>(pageData.getCurrent(), pageData.getSize());
        return baseMapper.pageList(page, pageData);
    }

    /**
     * 根据id查询后台用户信息.
     * @param params 查询参数
     * @return 用户信息
     */
    @Override
    public SystemUserItemVo systemUserSearchById(final SystemUserSearchByIdParams params) {

        SystemUser systemUser = baseMapper.selectById(params.getId());
        if (systemUser == null) {
            new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "用户不存在");
        }
        return SystemUserItemVo.convertToVo(systemUser);
    }

    @Override
    public void systemUserSaveOrUpdate(final SystemUserSaveOrUpdateParams params) {

        if (params != null && params.getPassword() != null) {
            params.setPassword(DigestUtils.md5Hex(params.getPassword()));
        }

        SystemUser systemUser = SystemUserSaveOrUpdateParams.convertToEntity(params);
        if (systemUser.getId() == null) {
            this.save(systemUser);
        } else {
            boolean exists = this.getById(systemUser.getId()) != null;
            if (exists) {
                this.updateById(systemUser);
            } else {
                throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "用户不存在");
            }
        }

    }

    /**
     * 根据用户名查询用户信息.
     * @param params 查询参数
     * @return 用户是否可用
     */
    @Override
    public Boolean userNameExists(final SystemUserSearchByNameParams params) {
        LambdaQueryWrapper<SystemUser> systemUserQueryWrapper = new LambdaQueryWrapper<>();
        systemUserQueryWrapper.eq(SystemUser::getUsername, params.getUsername());
        long count = this.count(systemUserQueryWrapper);
        return count == 0;
    }

    @Override
    public void systemUserRemoveById(final SystemUserRemoveByIdParams params) {

        boolean b = this.removeById(params.getId());
        if (!b) {
            throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "用户不存在");
        }

    }

    @Override
    public void updateStatusById(final SystemUserUpdateStatusParams params) {
        LambdaUpdateWrapper<SystemUser> userUpdateWrapper = new LambdaUpdateWrapper<>();
        userUpdateWrapper.eq(SystemUser::getId, params.getId());
        userUpdateWrapper.set(SystemUser::getStatus, params.getStatus());
        boolean b = this.update(userUpdateWrapper);
        if (!b) {
            throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "用户不存在");
        }
    }
}




