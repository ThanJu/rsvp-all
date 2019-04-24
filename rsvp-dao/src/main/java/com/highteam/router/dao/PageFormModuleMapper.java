package com.highteam.router.dao;

import com.highteam.router.model.PageFormModule;

public interface PageFormModuleMapper {
    int deleteByPrimaryKey(Integer pageFormModuleId);

    int insert(PageFormModule record);

    int insertSelective(PageFormModule record);

    PageFormModule selectByPrimaryKey(Integer pageFormModuleId);

    int updateByPrimaryKeySelective(PageFormModule record);

    int updateByPrimaryKey(PageFormModule record);
}