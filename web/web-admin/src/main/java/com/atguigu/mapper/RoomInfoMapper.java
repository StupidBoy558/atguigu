package com.atguigu.mapper;

import com.atguigu.entity.RoomInfo;
import com.atguigu.params.room.RoomPageItemParam;
import com.atguigu.vo.room.RoomPageVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author wf_wj
* @description 针对表【room_info(房间信息表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:48
* @Entity com.atguigu.entity.RoomInfo
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    /**
     * 根据条件分页查询房间列表.
     *
     * @param pageVoPage 分页参数
     * @param params     房间的分页查询参数
     * @return 房间分页列表
     */
    IPage<RoomPageVo> roomPageItem(
            @Param("page") Page<RoomPageVo> pageVoPage, @Param("params") RoomPageItemParam params);
}




