package com.atguigu.service;

import com.atguigu.entity.RoomInfo;
import com.atguigu.params.room.RoomGetByIdParam;
import com.atguigu.params.room.RoomListByApartmentIdParam;
import com.atguigu.params.room.RoomPageItemParam;
import com.atguigu.params.room.RoomRemoveByIdParam;
import com.atguigu.params.room.RoomSaveOrUpdateParam;
import com.atguigu.params.room.RoomUpdateStatusByIdParam;
import com.atguigu.vo.room.RoomInfoItemVo;
import com.atguigu.vo.room.RoomInfoVo;
import com.atguigu.vo.room.RoomPageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wf_wj
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2024-09-16 22:26:48
*/
public interface RoomInfoService extends IService<RoomInfo> {

    /**
     * 保存或更新房间的信息.
     *
     * @param params 房间的信息参数
     */
    void roomSaveOrUpdate(RoomSaveOrUpdateParam params);

    /**
     * 根据条件分页查询房间列表.
     *
     * @param params 房间的分页查询参数
     * @return 房间分页列表
     */
    IPage<RoomPageVo> roomPageItem(RoomPageItemParam params);

    /**
     * 更新房间的发布状态.
     *
     * @param params 房间的发布状态参数
     */
    void updateReleaseStatusById(RoomUpdateStatusByIdParam params);

    /**
     * 根据id查询房间详情.
     * @param params 房间的id
     * @return 房间的详情信息
     */
    RoomInfoItemVo roomGetDetailById(RoomGetByIdParam params);

    /**
     * 根据id删除房间.
     *
     * @param params 房间的id
     */
    void roomRemoveById(RoomRemoveByIdParam params);

    /**
     * 根据公寓id查询房间列表.
     * @param params 房间的公寓id
     */
    RoomInfoVo listBasicByApartmentId(RoomListByApartmentIdParam params);
}
