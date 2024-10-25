package com.atguigu.mapper;

import com.atguigu.entity.UserInfo;
import com.atguigu.params.user.UserInfoPageParams;
import com.atguigu.vo.user.UserInfoPageVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author wf_wj
* @description 针对表【user_info(用户信息表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:49
* @Entity com.atguigu.entity.UserInfo
*/
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 分页查询用户信息.
     *
     * @param page     分页参数
     * @param pageData 分页查询参数
     * @return 用户信息分页列表
     */
    IPage<UserInfoPageVo> pageList(Page<UserInfo> page, @Param("params") UserInfoPageParams pageData);
}




