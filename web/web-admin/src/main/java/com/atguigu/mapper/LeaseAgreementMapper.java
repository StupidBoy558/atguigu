package com.atguigu.mapper;

import com.atguigu.entity.LeaseAgreement;
import com.atguigu.params.agreement.AgreementPageParams;
import com.atguigu.params.agreement.AgreementSearchParams;
import com.atguigu.vo.agreement.AgreementPageVo;
import com.atguigu.vo.agreement.AgreementSearchVo;
import com.atguigu.vo.leaseTerm.LeaseAgreementListVo;
import com.atguigu.vo.leaseTerm.LeaseTermListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2024-09-16 22:26:48
* @Entity com.atguigu.entity.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    /**
     * 根据房间id查询租期列表
     *
     * @param roomId 房间id
     * @return 租期列表
     */
    List<LeaseTermListVo> listByRoomId(@Param("id") Long roomId);

    /**
     * @param page     分页对象
     * @param pageData 查询参数
     * @return 分页查询租约信息结果
     */
    IPage<AgreementPageVo> pageList(Page<LeaseAgreement> page, @Param("params") AgreementPageParams pageData);

}




