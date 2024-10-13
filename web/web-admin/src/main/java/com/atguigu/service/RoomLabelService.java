package com.atguigu.service;

import com.atguigu.entity.RoomLabel;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【room_label(房间&标签关联表)】的数据库操作Service
* @createDate 2024-09-16 22:26:48
*/
public interface RoomLabelService extends IService<RoomLabel> {

}
