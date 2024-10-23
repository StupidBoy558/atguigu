package com.atguigu.service;

import com.atguigu.entity.BrowsingHistory;
import com.atguigu.pojo.vo.history.HistoryItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author wf_wj
 * @description 针对表【browsing_history(浏览历史)】的数据库操作Service
 * @createDate 2024-10-19 09:50:34
 */
public interface BrowsingHistoryService extends IService<BrowsingHistory> {

    /**
     * 分页查询浏览历史
     *
     * @param page   分页对象
     * @param userId 用户ID
     * @return IPage<HistoryItemVo>
     */
    IPage<HistoryItemVo> pageItem(Page<HistoryItemVo> page, Long userId);

    /**
     * 保存浏览历史
     *
     * @param roomId 浏览历史ID
     * @param userId 用户ID
     */
    void saveBrowsingHistory(Long roomId, Long userId);
}
