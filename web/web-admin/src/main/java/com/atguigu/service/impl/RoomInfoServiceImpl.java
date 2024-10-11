package com.atguigu.service.impl;

import com.atguigu.params.room.RoomGetByIdParam;
import com.atguigu.params.room.RoomListByApartmentIdParam;
import com.atguigu.params.room.RoomPageItemParam;
import com.atguigu.params.room.RoomRemoveByIdParam;
import com.atguigu.params.room.RoomSaveOrUpdateParam;
import com.atguigu.params.room.RoomUpdateStatusByIdParam;
import com.atguigu.vo.room.RoomPageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.RoomInfo;
import com.atguigu.service.RoomInfoService;
import com.atguigu.mapper.RoomInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【room_info(房间信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
    implements RoomInfoService{

    /**
     * 保存或更新房间的信息.
     *
     * @param params 房间的信息参数
     */
    @Override
    public void roomSaveOrUpdate(RoomSaveOrUpdateParam params) {


    }

    /**
     * 分页查询房间的信息.
     *
     * @param params 查询参数
     * @return 房间信息列表
     */
    @Override
    public IPage<RoomPageVo> roomPageItem(RoomPageItemParam params) {
        IPage<RoomPageVo> o = null;
        return o;
    }

    /**
     * 更新房间的发布状态.
     *
     * @param params 房间的发布状态参数
     */
    @Override
    public void updateReleaseStatusById(RoomUpdateStatusByIdParam params) {

    }

    /**
     * 根据id获取房间详细信息.
     *
     * @param params 房间的id
     */
    @Override
    public void roomGetDetailById(RoomGetByIdParam params) {

    }

    /**
     * 根据id删除房间信息.
     *
     * @param params 房间的id
     */
    @Override
    public void roomRemoveById(RoomRemoveByIdParam params) {

    }

    /**
     * 根据公寓id查询房间列表.
     *
     * @param params 公寓id
     */
    @Override
    public void listBasicByApartmentId(RoomListByApartmentIdParam params) {

    }
}




