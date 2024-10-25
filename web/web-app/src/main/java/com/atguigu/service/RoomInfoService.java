package com.atguigu.service;

import com.atguigu.entity.RoomInfo;
import com.atguigu.pojo.vo.room.RoomDetailVo;
import com.atguigu.pojo.vo.room.RoomItemVo;
import com.atguigu.pojo.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author wf_wj
 * @description 针对表【room_info(房间信息表)】的数据库操作Service
 * @createDate 2024-10-19 09:50:35
 */
public interface RoomInfoService extends IService<RoomInfo> {

    /**
     * 分页查询房间列表.
     *
     * @param page    分页对象
     * @param queryVo 查询条件
     * @return IPage<RoomItemVo> 分页对象
     */
    IPage<RoomItemVo> pageList(Page<RoomItemVo> page, RoomQueryVo queryVo);

    /**
     * 根据id获取房间的详细信息.
     *
     * @param id 房间id
     * @return RoomDetailVo 房间详细信息
     */
    RoomDetailVo getDetailById(Long id);

    /**
     * 根据公寓id分页查询房间列表.
     *
     * @param page 分页对象
     * @param id   公寓id
     * @return IPage<RoomItemVo> 分页对象
     */
    IPage<RoomItemVo> pageListByApartmentId(Page<RoomItemVo> page, Long id);
}
