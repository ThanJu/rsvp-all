package com.highteam.router.dao;

import com.highteam.router.common.m.PageParam;
import com.highteam.router.model.ActivityInfo;

import java.util.List;

public interface ActivityInfoMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(ActivityInfo record);

    int insertSelective(ActivityInfo record);

    ActivityInfo selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(ActivityInfo record);

    int updateByPrimaryKey(ActivityInfo record);

    List<ActivityInfo> selectPageListByParam(PageParam<ActivityInfo> pageParam);

    int selectPageListCount(PageParam<ActivityInfo> pageParam);
}