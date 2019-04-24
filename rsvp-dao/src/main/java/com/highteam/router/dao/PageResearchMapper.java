package com.highteam.router.dao;

import com.highteam.router.model.PageResearch;

public interface PageResearchMapper {
    int deleteByPrimaryKey(Integer pageResearchId);

    int insert(PageResearch record);

    int insertSelective(PageResearch record);

    PageResearch selectByPrimaryKey(Integer pageResearchId);

    int updateByPrimaryKeySelective(PageResearch record);

    int updateByPrimaryKey(PageResearch record);
}