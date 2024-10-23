package com.atguigu.mapper;

import com.atguigu.entity.BrowsingHistory;
import com.atguigu.pojo.vo.history.HistoryItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @author wf_wj
 * @description 针对表【browsing_history(浏览历史)】的数据库操作Mapper
 * @createDate 2024-10-19 09:50:34
 * @Entity com.atguigu.entity.BrowsingHistory
 */
public interface BrowsingHistoryMapper extends BaseMapper<BrowsingHistory> {

    /**
     * 分页查询浏览历史
     *
     * @param page   分页对象
     * @param userId 用户ID
     * @return IPage<HistoryItemVo>
     */
    IPage<HistoryItemVo> pageItem(Page<HistoryItemVo> page, @Param("id") Long userId);
}




