package com.atguigu.service.impl;

import com.atguigu.params.user.UserInfoPageParams;
import com.atguigu.params.user.UserUpdateStatusParams;
import com.atguigu.vo.user.UserInfoPageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
     *
     * @param params 分页查询参数
     * @return 用户信息分页列表
     */
    @Override
    public IPage<UserInfoPageVo> pageUserInfo(UserInfoPageParams params) {
        return null;
    }

    /**
     * 根据用户id更新账号状态.
     *
     * @param params 更新参数
     * @return 更新结果
     */
    @Override
    public Void updateStatusById(UserUpdateStatusParams params) {

        return null;
    }
}




