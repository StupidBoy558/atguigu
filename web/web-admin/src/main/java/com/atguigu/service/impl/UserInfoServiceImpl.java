package com.atguigu.service.impl;

import com.atguigu.params.user.UserInfoPageParams;
import com.atguigu.params.user.UserUpdateStatusParams;
import com.atguigu.vo.user.UserInfoPageVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.UserInfo;
import com.atguigu.service.UserInfoService;
import com.atguigu.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:49
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

    /**
     * 分页查询用户信息.
     * @param pageData 分页查询参数
     * @return 用户信息分页列表
     */
    @Override
    public IPage<UserInfoPageVo> pageList(final UserInfoPageParams pageData) {

        Page<UserInfo> page = new Page<>(pageData.getCurrent(), pageData.getSize());
        return baseMapper.pageList(page, pageData);
    }

    /**
     * 根据用户id更新账号状态.
     *
     * @param params 更新参数
     * @return 更新结果
     */
    @Override
    public Void updateStatusById(UserUpdateStatusParams params) {

        LambdaUpdateWrapper<UserInfo> userUpdateWrapper = new LambdaUpdateWrapper<>();
        userUpdateWrapper.eq(UserInfo::getId, params.getId())
                .set(UserInfo::getStatus, params.getStatus());
        int update = baseMapper.update(null, userUpdateWrapper);

        if (update > 0) {
            return null;
        }
        throw new RuntimeException("更新失败");
    }
}




