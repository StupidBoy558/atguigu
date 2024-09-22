package com.atguigu.service.impl;

import com.atguigu.entity.LabelInfo;
import com.atguigu.mapper.LabelInfoMapper;
import com.atguigu.params.labelInfo.LabelInfoDeleteParam;
import com.atguigu.params.labelInfo.LabelInfoListParam;
import com.atguigu.params.labelInfo.LabelInfoSaveParam;
import com.atguigu.params.labelInfo.LabelInfoUpdateParam;
import com.atguigu.service.LabelInfoService;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

        // 将param转换为实体类
        LabelInfo labelInfo = new LabelInfo();
        BeanUtils.copyProperties(param, labelInfo);

        // 设置默认值
        labelInfo.setCreateTime(new Date());
        labelInfo.setIsDeleted((byte) 0);

        // 保存
        this.save(labelInfo);
        return "id:" + labelInfo.getId();
    }

    @Override
    public Boolean updateLabel(LabelInfoUpdateParam param) {

        // 将param转换为实体类
        LabelInfo labelInfoNew = LabelInfoUpdateParam.convertToEntity(param);

        // 设置更新时间
        labelInfoNew.setUpdateTime(new Date());

        // 尝试更新数据库中的记录
        boolean updateResult = this.updateById(labelInfoNew);
        if (!updateResult) {
            return false;
        }

        return true;

    }

    @Override
    public Boolean deleteLabel(LabelInfoDeleteParam param) {

        // 尝试删除数据库中的记录
        return this.removeById(param.getId());
    }

}




