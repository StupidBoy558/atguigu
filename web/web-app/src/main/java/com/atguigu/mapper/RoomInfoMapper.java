package com.atguigu.mapper;

import com.atguigu.entity.RoomInfo;
import com.atguigu.pojo.vo.room.RoomItemVo;
import com.atguigu.pojo.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @author wf_wj
 * @description 针对表【room_info(房间信息表)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:35
 * @Entity com.atguigu.entity.RoomInfo
 */
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    /**
     * 分页查询房间列表.
     *
     * @param page    分页对象
     * @param queryVo 查询条件
     * @return IPage<RoomItemVo> 分页对象
     */
    IPage<RoomItemVo> pageList(Page<RoomItemVo> page, @Param("params") RoomQueryVo queryVo);
}




