package com.highteam.router.dao;

import com.highteam.router.common.m.PageParam;
import com.highteam.router.model.ActivityPage;

import java.util.List;

public interface ActivityPageMapper {
    int deleteByPrimaryKey(Integer pageManageId);

    int insert(ActivityPage record);

    int insertSelective(ActivityPage record);

    ActivityPage selectByPrimaryKey(Integer pageManageId);

    int updateByPrimaryKeySelective(ActivityPage record);

    int updateByPrimaryKeyWithBLOBs(ActivityPage record);

    int updateByPrimaryKey(ActivityPage record);

    List<ActivityPage> selectPageListByParam(PageParam<ActivityPage> pageParam);

    int selectPageListCount(PageParam<ActivityPage> pageParam);
}