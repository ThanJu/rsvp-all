package com.highteam.router.dao;

import com.highteam.router.common.m.PageParam;
import com.highteam.router.model.DataSign;

import java.util.List;

public interface DataSignMapper {
    int deleteByPrimaryKey(Integer dataSignId);

    int insert(DataSign record);

    int insertSelective(DataSign record);

    DataSign selectByPrimaryKey(Integer dataSignId);

    int updateByPrimaryKeySelective(DataSign record);

    int updateByPrimaryKey(DataSign record);

    List<DataSign> selectPageListByParam(PageParam<DataSign> pageParam);

    int selectPageListCount(PageParam<DataSign> pageParam);
}