package com.atguigu.service;

import com.atguigu.entity.SystemPost;
import com.atguigu.params.system.SystemPostPageParams;
import com.atguigu.params.system.SystemPostRemoveParams;
import com.atguigu.params.system.SystemPostSaveOrUdpateParams;
import com.atguigu.params.system.SystemPostSearchParams;
import com.atguigu.params.system.SystemPostUpdateStatusParams;
import com.atguigu.vo.system.SystemPostListVo;
import com.atguigu.vo.system.SystemPostPageVo;
import com.atguigu.vo.system.SystemPostSearchVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【system_post(岗位信息表)】的数据库操作Service
* @createDate 2024-09-16 22:26:49
*/
public interface SystemPostService extends IService<SystemPost> {

    /**
     * 分页查询岗位信息.
     *
     * @param params 分页查询参数
     * @return 岗位信息分页数据
     */
    IPage<SystemPostPageVo> systemPageItem(SystemPostPageParams params);

    /**
     * 新增或修改岗位信息.
     *
     * @param params 新增或修改岗位信息参数
     */
    void systemPostSaveOrUpdate(SystemPostSaveOrUdpateParams params);

    /**
     * 根据id删除岗位信息.
     *
     * @param params 删除岗位信息参数
     */
    void systemPostRemoveById(SystemPostRemoveParams params);

    /**
     * 查询岗位列表.
     *
     * @return 岗位列表
     */
    List<SystemPostListVo> systemPostList();

    /**
     * 根据id查询岗位信息.
     *
     * @param params 查询岗位信息参数
     * @return 岗位信息
     */
    SystemPostSearchVo systemPostGetById(SystemPostSearchParams params);

    /**
     * 根据岗位id更新岗位状态.
     *
     * @param params 更新岗位状态参数
     */
    void updateStatusByPostId(SystemPostUpdateStatusParams params);
}
