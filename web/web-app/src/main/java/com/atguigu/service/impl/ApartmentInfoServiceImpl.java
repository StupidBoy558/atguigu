package com.atguigu.service.impl;

import com.atguigu.pojo.vo.apartment.ApartmentDetailVo;
import com.atguigu.pojo.vo.apartment.ApartmentItemVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.ApartmentInfo;
import com.atguigu.service.ApartmentInfoService;
import com.atguigu.mapper.ApartmentInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author wf_wj
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:34
 */
@Service
@RequiredArgsConstructor
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

    private final ApartmentInfoMapper apartmentInfoMapper;

    @Override
    public ApartmentItemVo getItemVoById(Long apartmentId) {

        return apartmentInfoMapper.getItemVoById(apartmentId);
    }

    @Override
    public ApartmentDetailVo getDetailById(Long id) {

        return null;
    }
}




