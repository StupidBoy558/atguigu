package com.atguigu.mapper;

import com.atguigu.entity.LabelInfo;
import com.atguigu.vo.labelInfo.LabelInfoListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wf_wj
* @description 针对表【label_info(标签信息表)】的数据库操作Mapper
* @createDate 2024-09-15 08:49:34
* @Entity com.atguigu.entity.LabelInfo
*/
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    /**
     * 根据公寓ID查询标签列表.
     *
     * @param apartmentId 公寓ID
     * @return 标签列表
     */
    List<LabelInfoListVo> selectListById(@Param("id") Long apartmentId);
}




