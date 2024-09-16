package com.atguigu.service;

import com.atguigu.entity.LabelInfo;
import com.atguigu.params.labelInfo.LabelInfoDeleteParam;
import com.atguigu.params.labelInfo.LabelInfoListParam;
import com.atguigu.params.labelInfo.LabelInfoSaveParam;
import com.atguigu.params.labelInfo.LabelInfoUpdateParam;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【label_info(标签信息表)】的数据库操作Service
* @createDate 2024-09-15 08:49:34
*/
public interface LabelInfoService extends IService<LabelInfo> {

    /**
     * （根据类型）查询标签列表
     *
     * @param param
     * @return
     */
    List<LabelInfoListVo> listByTypeLabel(LabelInfoListParam param);

    /**
     * 新增标签
     * @param param
     * @return
     */
    String addLabel(LabelInfoSaveParam param);

    /**
     * 更新标签
     * @param param
     * @return
     */
    Boolean updateLabel(LabelInfoUpdateParam param);

    /**
     * 删除标签
     * @param param
     * @return
     */
    Boolean deleteLabel(LabelInfoDeleteParam param);
}
