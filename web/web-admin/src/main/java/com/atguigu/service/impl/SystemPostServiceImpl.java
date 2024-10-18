package com.atguigu.service.impl;

import com.atguigu.exception.LeaseException;
import com.atguigu.params.system.SystemPostPageParams;
import com.atguigu.params.system.SystemPostRemoveParams;
import com.atguigu.params.system.SystemPostSaveOrUdpateParams;
import com.atguigu.params.system.SystemPostSearchParams;
import com.atguigu.params.system.SystemPostUpdateStatusParams;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.vo.BaseVo;
import com.atguigu.vo.system.SystemPostListVo;
import com.atguigu.vo.system.SystemPostPageVo;
import com.atguigu.vo.system.SystemPostSearchVo;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        implements SystemPostService {

    @Override
    public IPage<SystemPostPageVo> systemPageItem(final SystemPostPageParams pageData) {

        Page<SystemPost> page = new Page<>(pageData.getCurrent(), pageData.getSize());
        return baseMapper.pageList(page);
    }

    @Override
    public void systemPostSaveOrUpdate(final SystemPostSaveOrUdpateParams params) {

        Long systemPostId = params.getId();
        SystemPost systemPost = SystemPostSaveOrUdpateParams.convertToEntity(params);

        if (systemPostId == null) {
            this.save(systemPost);
        } else {
            boolean exists = this.getById(systemPostId) != null;
            if (exists) {
                this.updateById(systemPost);
            } else {
                throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "更新失败，数据不存在");
            }
        }

    }

    @Override
    public void systemPostRemoveById(final SystemPostRemoveParams params) {

        boolean result = this.removeById(params.getId());
        if (!result) {
            throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "删除失败，未找到对应的记录");
        }
    }

    @Override
    public List<SystemPostListVo> systemPostList() {
        List<SystemPost> list = this.list();
        return BaseVo.convertToVoList(list, SystemPostListVo.class);
    }

    @Override
    public SystemPostSearchVo systemPostGetById(final SystemPostSearchParams params) {
        SystemPost systemPost = baseMapper.selectById(params.getId());
        if (systemPost != null) {
            return SystemPostSearchVo.convertToVo(systemPost);
        }
        throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "查询失败");
    }

    @Override
    public void updateStatusByPostId(final SystemPostUpdateStatusParams params) {
        LambdaUpdateWrapper<SystemPost> postUpdateWrapper = new LambdaUpdateWrapper<>();
        postUpdateWrapper.eq(SystemPost::getId, params.getId());
        postUpdateWrapper.set(SystemPost::getStatus, params.getStatus());
        boolean result = this.update(postUpdateWrapper);
        if (!result) {
            throw new LeaseException(ResultCodeEnum.PARAM_ERROR.getCode(), "更新失败");
        }
    }
}




