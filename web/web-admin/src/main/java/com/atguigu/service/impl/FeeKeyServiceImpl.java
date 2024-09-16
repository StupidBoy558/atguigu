package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.FeeKey;
import com.atguigu.service.FeeKeyService;
import com.atguigu.mapper.FeeKeyMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService{

}




