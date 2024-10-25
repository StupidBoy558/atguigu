package com.atguigu.service.impl;

import com.atguigu.vo.regionInfo.ProvinceInfoVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.ProvinceInfo;
import com.atguigu.service.ProvinceInfoService;
import com.atguigu.mapper.ProvinceInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf_wj.
 * @description: 针对表【province_info】的数据库操作Service实现
 * @createDate: 2024-09-16 22:26:49
*/
@Service
public class ProvinceInfoServiceImpl extends ServiceImpl
        <ProvinceInfoMapper, ProvinceInfo> implements ProvinceInfoService {

    /**
     * 查询省份信息列表.
     *
     * @return 省份信息列表VO
     */
    @Override
    public List<ProvinceInfoVo> listProvince() {

        List<ProvinceInfo> provinceInfoEntity = this.list();
        if (provinceInfoEntity != null && !provinceInfoEntity.isEmpty()) {
            return ProvinceInfoVo.convertToVo(provinceInfoEntity);
        }
        return null;
    }
}




