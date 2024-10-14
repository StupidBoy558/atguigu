package com.atguigu.service.impl;

import com.atguigu.params.agreement.AgreementPageParams;
import com.atguigu.params.agreement.AgreementRemoveByIdParams;
import com.atguigu.params.agreement.AgreementSearchParams;
import com.atguigu.params.agreement.LeaseAgreementSaveOrUpdateParams;
import com.atguigu.vo.agreement.AgreementPageVo;
import com.atguigu.vo.agreement.AgreementSearchVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.entity.LeaseAgreement;
import com.atguigu.service.LeaseAgreementService;
import com.atguigu.mapper.LeaseAgreementMapper;
import org.springframework.stereotype.Service;

/**
* @author wf_wj
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service实现
* @createDate 2024-09-16 22:26:48
*/
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
    implements LeaseAgreementService{

    /**
     * 保存或更新租约信息.
     *
     * @param params 保存或更新租约信息参数
     */
    @Override
    public void agreementSaveOrUpdate(final LeaseAgreementSaveOrUpdateParams params) {

    }

    /**
     * 分页查询租约信息.
     *
     * @param params 分页查询租约信息参数
     * @return 分页查询租约信息结果
     */
    @Override
    public IPage<AgreementPageVo> agreementPageItem(final AgreementPageParams params) {

        return null;
    }

    /**
     * 根据ID查询租约信息.
     *
     * @param params 根据ID查询租约信息参数
     * @return 根据ID查询租约信息结果
     */
    @Override
    public AgreementSearchVo agreementSearchById(AgreementSearchParams params) {
        return null;
    }

    /**
     * 根据ID删除租约信息.
     *
     * @param params 根据ID删除租约信息参数
     */
    @Override
    public void agreementRemoveById(AgreementRemoveByIdParams params) {

    }
}




