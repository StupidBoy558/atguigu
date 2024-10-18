package com.atguigu.mapper;

import com.atguigu.entity.SystemPost;
import com.atguigu.vo.system.SystemPostPageVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* @author wf_wj
* @description 针对表【system_post(岗位信息表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:49
* @Entity com.atguigu.entity.SystemPost
*/
public interface SystemPostMapper extends BaseMapper<SystemPost> {

    /**
     * 分页查询岗位信息.
     *
     * @param page 分页查询参数
     * @return 岗位信息分页数据
     */
    IPage<SystemPostPageVo> pageList(Page<SystemPost> page);
}




