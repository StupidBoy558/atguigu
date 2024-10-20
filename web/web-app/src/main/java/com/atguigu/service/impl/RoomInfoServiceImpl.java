package com.atguigu.service.impl;

import com.atguigu.pojo.vo.room.RoomItemVo;
import com.atguigu.pojo.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.RoomInfo;
import com.atguigu.service.RoomInfoService;
import com.atguigu.mapper.RoomInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author wf_wj
 * @description 针对表【room_info(房间信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:35
 */
@Service
@RequiredArgsConstructor
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    private final RoomInfoMapper roomInfoMapper;

    /**
     * 分页查询房间列表.
     *
     * @param page    分页对象
     * @param queryVo 查询条件
     * @return IPage<RoomItemVo> 分页对象
     */
    @Override
    public IPage<RoomItemVo> pageList(Page<RoomItemVo> page, RoomQueryVo queryVo) {

        return roomInfoMapper.pageList(page, queryVo);
    }
}




