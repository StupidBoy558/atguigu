package com.atguigu.service.impl;

import com.atguigu.entity.LeaseTerm;
import com.atguigu.mapper.LeaseTermMapper;
import com.atguigu.params.leaseTerm.LeaseTermDeleteParam;
import com.atguigu.params.leaseTerm.LeaseTermListParams;
import com.atguigu.params.leaseTerm.LeaseTermSaveParam;
import com.atguigu.params.leaseTerm.LeaseTermUpdateParam;
import com.atguigu.service.LeaseTermService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author wf_wj
* @description 针对表【lease_term(租期)】的数据库操作Service实现
* @createDate 2024-09-15 08:49:34
*/
@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
    implements LeaseTermService{

    @Override
    public List<LeaseTerm> listLeaseTerm(LeaseTermListParams param) {

        LambdaQueryWrapper<LeaseTerm> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LeaseTerm::getIsDeleted, 0);
        return list(queryWrapper);

    }

    @Override
    public String addLeaseTerm(LeaseTermSaveParam param) {

        // 将param转换为实体
        LeaseTerm leaseTerm = new LeaseTerm();
        BeanUtils.copyProperties(param, leaseTerm);

        // 保存
        leaseTerm.setCreateTime(new Date());
        leaseTerm.setIsDeleted((byte) 0);

        boolean save = this.save(leaseTerm);
        return save ? "新增成功，ID：" + leaseTerm.getId() : "新增失败";
    }

    @Override
    public Boolean updateLeaseTerm(LeaseTermUpdateParam param) {

        // Fetch the existing LeaseTerm from the database
        LeaseTerm existingLeaseTerm = this.getById(param.getId());
        if (existingLeaseTerm == null) {
            throw new IllegalArgumentException("LeaseTerm with ID " + param.getId() + " does not exist");
        }

        /*
          TODO:Copy non-null properties from param to existingLeaseTerm
         */
        BeanUtils.copyProperties(param, existingLeaseTerm);

        // Update the updateTime
        existingLeaseTerm.setUpdateTime(new Date());
        return this.updateById(existingLeaseTerm);
    }

    @Override
    public Boolean deleteLeaseTerm(LeaseTermDeleteParam param) {

        // Fetch the existing LeaseTerm from the database
        LeaseTerm existingLeaseTerm = this.getById(param.getId());
        if (existingLeaseTerm == null) {
            throw new IllegalArgumentException("LeaseTerm with ID " + param.getId() + " does not exist");
        }

        // Soft delete the LeaseTerm
        return this.removeById(param.getId());
    }
}




