package com.atguigu.mapper;

import com.atguigu.entity.ApartmentInfo;
import com.atguigu.params.apartment.ApartmentSearchParams;
import com.atguigu.vo.apartment.ApartmentItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author wf_wj
 * @description: 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
 * @createDate: 2024-09-16 22:26:48
 * @Entity: com.atguigu.entity.ApartmentInfo
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    /**
     * 分页查询公寓信息.
     *
     * @param page  分页参数
     * @param param 查询参数
     * @return 公寓信息列表
     */
    IPage<ApartmentItemVo> apartmentPageItem(
            Page<ApartmentItemVo> page, ApartmentSearchParams param);
}




