package com.atguigu.service.impl;

import com.atguigu.pojo.vo.fee.FeeValueVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.FeeValue;
import com.atguigu.service.FeeValueService;
import com.atguigu.mapper.FeeValueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf_wj
 * @description 针对表【fee_value(杂项费用值表)】的数据库操作Service实现
 * @createDate 2024-10-19 09:50:34
 */
@Service
@RequiredArgsConstructor
public class FeeValueServiceImpl extends ServiceImpl<FeeValueMapper, FeeValue>
        implements FeeValueService {

    private final FeeValueMapper feeValueMapper;

    @Override
    public List<FeeValueVo> getFeeValueByApartmentId(Long id) {

        return feeValueMapper.getFeeValueByApartmentId(id);
    }
}




