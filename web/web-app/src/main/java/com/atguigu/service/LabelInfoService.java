package com.atguigu.service;

import com.atguigu.entity.LabelInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【label_info(标签信息表)】的数据库操作Service
 * @createDate 2024-10-19 09:50:34
 */
public interface LabelInfoService extends IService<LabelInfo> {

    /**
     * 根据房间id获取标签信息.
     *
     * @param id 房间id
     * @return List<LabelInfo> 标签信息
     */
    List<LabelInfo> getLabelInfoByRoomId(Long id);
}
