package com.highteam.router.dao;

import com.highteam.router.model.DataUser;

public interface DataUserMapper {
    int deleteByPrimaryKey(Integer dataUserId);

    int insert(DataUser record);

    int insertSelective(DataUser record);

    DataUser selectByPrimaryKey(Integer dataUserId);

    int updateByPrimaryKeySelective(DataUser record);

    int updateByPrimaryKey(DataUser record);
}