package com.highteam.router.dao;

import com.highteam.router.model.AppLog;
import com.highteam.router.model.AppLogWithBLOBs;

public interface AppLogMapper {
    int deleteByPrimaryKey(Long logid);

    int insert(AppLogWithBLOBs record);

    int insertSelective(AppLogWithBLOBs record);

    AppLogWithBLOBs selectByPrimaryKey(Long logid);

    int updateByPrimaryKeySelective(AppLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AppLogWithBLOBs record);

    int updateByPrimaryKey(AppLog record);
}