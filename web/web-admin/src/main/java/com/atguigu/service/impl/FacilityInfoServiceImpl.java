package com.atguigu.service.impl;

import com.atguigu.params.facilityInfo.FacilityInfoListParams;
import com.atguigu.params.facilityInfo.FacilityInfoPageParams;
import com.atguigu.params.facilityInfo.FacilityInfoSaveOrUpdateParams;
import com.atguigu.vo.facilityInfo.FacilityInfoListVo;
import com.atguigu.vo.facilityInfo.FacilityInfoPageVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.FacilityInfo;
import com.atguigu.service.FacilityInfoService;
import com.atguigu.mapper.FacilityInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
* @author: wf_wj
* @description: 针对表【facility_info(配套信息表)】的数据库操作Service实现
* @createDate: 2024-09-16 22:26:48
*/
@Service
public class FacilityInfoServiceImpl extends ServiceImpl
        <FacilityInfoMapper, FacilityInfo> implements FacilityInfoService {

    /**
     * 获取设施列表.
     * @param param 设施信息列表参数类
     * @return 设施信息列表
     */
    @Override
    public List<FacilityInfoListVo> listFacility(
            final FacilityInfoListParams param) {

        // 判断type参数是否为空
        LambdaQueryWrapper<FacilityInfo> queryWrapper =
                new LambdaQueryWrapper<>();

        queryWrapper.eq(
                param.getType() != null && !param.getType().isEmpty(),
                FacilityInfo::getType, param.getType());

        List<FacilityInfo> facilityEntity = this.list(queryWrapper);

        // 将实体类对象转换为VO对象
        return FacilityInfoListVo.convertToVoList(facilityEntity);

    }

    /**
     * 分页获取设施列表.
     * @param param 设施信息列表参数类
     * @return 设施信息列表
     */
    @Override
    public Page<FacilityInfoPageVo> pageFacility(
            final FacilityInfoPageParams param) {

        // 创建分页对象
        Page<FacilityInfo> page = new Page<>(
                param.getPageNum(), param.getPageSize());

        // 创建查询条件
        LambdaQueryWrapper<FacilityInfo> wrapper = new LambdaQueryWrapper<>();

        // 执行分页查询
        Page<FacilityInfo> facilityPage = this.page(page, wrapper);

        // 将实体类对象转换为VO对象
        Page<FacilityInfoPageVo> voPage = new Page<>();
        voPage.setCurrent(facilityPage.getCurrent());
        voPage.setSize(facilityPage.getSize());
        voPage.setTotal(facilityPage.getTotal());
        voPage.setRecords(
                FacilityInfoPageVo.convertToVoList(facilityPage.getRecords()));

        return voPage;
    }

    /**
     * 保存或更新设施信息.
     * @param param 保存或更新请求体
     * @return 是否成功
     */
    @Override
    public Boolean saveOrUpdateFacility(final FacilityInfoSaveOrUpdateParams param) {

        // 判断参数中的id值是否为空
        FacilityInfo facility = FacilityInfoSaveOrUpdateParams.convertToEntity(param);
        if (param.getId() == null) {
            // 新增设施信息
            facility.setCreateTime(new Date());
            facility.setIsDeleted(0);
            return this.save(facility);
        }  else {
            // 更新设施信息
            FacilityInfo facilityInfoOld = this.getById(param.getId());
            if (facilityInfoOld != null) {
                BeanUtils.copyProperties(
                        facility, facilityInfoOld,
                        "id", "createTime", "isDeleted");
                facilityInfoOld.setUpdateTime(new Date());
                return this.updateById(facilityInfoOld);
            } else {
                return false;
            }
        }

    }
}




