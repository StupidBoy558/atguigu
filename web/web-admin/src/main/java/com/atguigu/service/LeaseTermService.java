package com.atguigu.service;

import com.atguigu.entity.LeaseTerm;
import com.atguigu.params.leaseTerm.LeaseTermDeleteParam;
import com.atguigu.params.leaseTerm.LeaseTermListParams;
import com.atguigu.params.leaseTerm.LeaseTermSaveParam;
import com.atguigu.params.leaseTerm.LeaseTermUpdateParam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【lease_term(租期)】的数据库操作Service
* @createDate 2024-09-15 08:49:34
*/
public interface LeaseTermService extends IService<LeaseTerm> {

    /**
     * 查询全部租期列表
     * @param param
     * @return
     */
    List<LeaseTerm> listLeaseTerm(LeaseTermListParams param);

    /**
     * 新增租期
     * @param param
     * @return
     */
    String addLeaseTerm(LeaseTermSaveParam param);

    /**
     * 修改租期
     * @param param
     * @return
     */
    Boolean updateLeaseTerm(LeaseTermUpdateParam param);

    /**
     * 删除租期
     * @param param
     * @return
     */
    Boolean deleteLeaseTerm(LeaseTermDeleteParam param);
}
