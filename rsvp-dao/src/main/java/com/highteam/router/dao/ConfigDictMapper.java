package com.highteam.router.dao;

import com.highteam.router.common.m.PageParam;
import com.highteam.router.model.ConfigDict;

import java.util.List;

public interface ConfigDictMapper {
    int deleteByPrimaryKey(Integer pageTypeId);

    int insert(ConfigDict record);

    int insertSelective(ConfigDict record);

    ConfigDict selectByPrimaryKey(Integer pageTypeId);

    int updateByPrimaryKeySelective(ConfigDict record);

    int updateByPrimaryKey(ConfigDict record);

    List<ConfigDict> selectPageListByParam(PageParam<ConfigDict> pageParam);

    int selectPageListCount(PageParam<ConfigDict> pageParam);
}