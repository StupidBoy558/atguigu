package com.atguigu.service;

import com.atguigu.entity.UserInfo;
import com.atguigu.params.user.UserInfoPageParams;
import com.atguigu.params.user.UserUpdateStatusParams;
import com.atguigu.vo.user.UserInfoPageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wf_wj
 * @description: 针对表【user_info(用户信息表)】的数据库操作Service
 * @createDate: 2024-09-16 22:26:49
*/
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 分页查询用户信息.
     *
     * @param pageData 分页查询参数
     * @return 用户信息分页列表
     */
    IPage<UserInfoPageVo> pageList(UserInfoPageParams pageData);

    /**
     * 根据用户id更新账号状态.
     *
     * @param params 更新参数
     * @return 更新结果
     */
    Void updateStatusById(UserUpdateStatusParams params);
}
