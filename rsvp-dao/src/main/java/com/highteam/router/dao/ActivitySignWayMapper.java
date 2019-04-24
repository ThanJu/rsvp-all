package com.highteam.router.dao;

import com.highteam.router.common.m.PageParam;
import com.highteam.router.model.ActivitySignWay;

import java.util.List;

public interface ActivitySignWayMapper {
    int deleteByPrimaryKey(Integer signWayId);

    int insert(ActivitySignWay record);

    int insertSelective(ActivitySignWay record);

    ActivitySignWay selectByPrimaryKey(Integer signWayId);

    int updateByPrimaryKeySelective(ActivitySignWay record);

    int updateByPrimaryKey(ActivitySignWay record);

    List<ActivitySignWay> selectPageListByParam(PageParam<ActivitySignWay> pageParam);

    int selectPageListCount(PageParam<ActivitySignWay> pageParam);
}