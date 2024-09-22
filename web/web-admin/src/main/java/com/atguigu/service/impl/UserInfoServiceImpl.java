package com.atguigu.service.impl;

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

}




