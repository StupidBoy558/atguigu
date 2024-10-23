package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.LabelInfo;
import com.atguigu.service.LabelInfoService;
import com.atguigu.mapper.LabelInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【label_info(标签信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:34
 */
@Service
@RequiredArgsConstructor
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo>
        implements LabelInfoService {

    private final LabelInfoMapper labelInfoMapper;

    @Override
    public List<LabelInfo> getLabelInfoByRoomId(Long id) {

        return labelInfoMapper.getLabelInfoByRoomId(id);
    }
}




