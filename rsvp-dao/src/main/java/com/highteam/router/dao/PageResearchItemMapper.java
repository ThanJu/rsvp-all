package com.highteam.router.dao;

import com.highteam.router.model.PageResearchItem;

public interface PageResearchItemMapper {
    int deleteByPrimaryKey(Integer pageResearchItemId);

    int insert(PageResearchItem record);

    int insertSelective(PageResearchItem record);

    PageResearchItem selectByPrimaryKey(Integer pageResearchItemId);

    int updateByPrimaryKeySelective(PageResearchItem record);

    int updateByPrimaryKey(PageResearchItem record);
}