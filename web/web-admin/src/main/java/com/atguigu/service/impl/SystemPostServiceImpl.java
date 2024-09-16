package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.SystemPost;
import com.atguigu.service.SystemPostService;
import com.atguigu.mapper.SystemPostMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【system_post(岗位信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:49
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService{

}




