package com.highteam.router.dao;

import com.highteam.router.model.PageTemplate;

public interface PageTemplateMapper {
    int deleteByPrimaryKey(Integer templateId);

    int insert(PageTemplate record);

    int insertSelective(PageTemplate record);

    PageTemplate selectByPrimaryKey(Integer templateId);

    int updateByPrimaryKeySelective(PageTemplate record);

    int updateByPrimaryKeyWithBLOBs(PageTemplate record);

    int updateByPrimaryKey(PageTemplate record);
}