package com.atguigu.service;

import com.atguigu.entity.LeaseAgreement;
import com.atguigu.params.agreement.AgreementPageParams;
import com.atguigu.params.agreement.AgreementRemoveByIdParams;
import com.atguigu.params.agreement.AgreementSearchParams;
import com.atguigu.params.agreement.AgreementUpdateStatusByIdParams;
import com.atguigu.params.agreement.LeaseAgreementSaveOrUpdateParams;
import com.atguigu.vo.agreement.AgreementPageVo;
import com.atguigu.vo.agreement.AgreementSearchVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wf_wj
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
* @createDate 2024-09-16 22:26:48
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    /**
     * 保存或更新租约信息.
     *
     * @param params 保存或更新租约信息参数
     */
    void agreementSaveOrUpdate(LeaseAgreementSaveOrUpdateParams params);

    /**
     * 分页查询租约信息.
     *
     * @param params 分页查询租约信息参数
     * @return 分页查询租约信息结果
     */
    IPage<AgreementPageVo> agreementPageItem(AgreementPageParams params);

    /**
     * 根据ID查询租约信息.
     *
     * @param params 根据ID查询租约信息参数
     * @return 根据ID查询租约信息结果
     */
    AgreementSearchVo agreementSearchById(AgreementSearchParams params);

    /**
     * 根据ID删除租约信息.
     *
     * @param params 根据ID删除租约信息参数
     */
    void agreementRemoveById(AgreementRemoveByIdParams params);

    /**
     * 根据ID更新租约状态.
     * @param params 根据ID更新租约状态参数
     */
    void agreementUpdateStatusById(AgreementUpdateStatusByIdParams params);
}
