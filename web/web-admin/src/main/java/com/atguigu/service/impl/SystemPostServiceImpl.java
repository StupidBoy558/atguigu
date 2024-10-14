package com.atguigu.service.impl;

import com.atguigu.params.system.SystemPostPageParams;
import com.atguigu.params.system.SystemPostRemoveParams;
import com.atguigu.params.system.SystemPostSaveOrUdpateParams;
import com.atguigu.params.system.SystemPostSearchParams;
import com.atguigu.params.system.SystemPostUpdateStatusParams;
import com.atguigu.vo.system.SystemPostListVo;
import com.atguigu.vo.system.SystemPostPageVo;
import com.atguigu.vo.system.SystemPostSearchVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.SystemPost;
import com.atguigu.service.SystemPostService;
import com.atguigu.mapper.SystemPostMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【system_post(岗位信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:49
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService{

    @Override
    public IPage<SystemPostPageVo> systemPageItem(SystemPostPageParams params) {
        return null;
    }

    @Override
    public void systemPostSaveOrUpdate(SystemPostSaveOrUdpateParams params) {

    }

    @Override
    public void systemPostRemoveById(SystemPostRemoveParams params) {

    }

    @Override
    public List<SystemPostListVo> systemPostList() {
        return List.of();
    }

    @Override
    public SystemPostSearchVo systemPostGetById(SystemPostSearchParams params) {
        return null;
    }

    @Override
    public void updateStatusByPostId(SystemPostUpdateStatusParams params) {

    }
}




