package com.atguigu.service.impl;

import com.atguigu.entity.LabelInfo;
import com.atguigu.mapper.LabelInfoMapper;
import com.atguigu.params.labelInfo.LabelInfoListParam;
import com.atguigu.params.labelInfo.LabelInfoSaveParam;
import com.atguigu.service.LabelInfoService;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author wf_wj
* @description 针对表【label_info(标签信息表)】的数据库操作Service实现
* @createDate 2024-09-15 08:49:34
*/
@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo>
    implements LabelInfoService{

    @Override
    public List<LabelInfoListVo> listByTypeLabel(LabelInfoListParam param) {

        LambdaQueryWrapper<LabelInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(param.getType() != null && !param.getType().isEmpty(), LabelInfo::getType, param.getType());
        List<LabelInfo> labelInfoList = this.list(queryWrapper);

        return LabelInfoListVo.convertToVoList(labelInfoList);
    }

    @Override
    public String addLabel(LabelInfoSaveParam param) {

        LabelInfo labelInfo = new LabelInfo();
        BeanUtils.copyProperties(param, labelInfo);

        labelInfo.setCreateTime(new Date());
        labelInfo.setIsDeleted((byte) 0);
        this.save(labelInfo);
        return "id:" + labelInfo.getId();
    }

}




