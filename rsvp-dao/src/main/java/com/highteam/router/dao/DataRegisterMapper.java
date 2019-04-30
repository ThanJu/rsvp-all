package com.highteam.router.dao;

import com.highteam.router.common.m.PageParam;
import com.highteam.router.model.DataRegister;

import java.util.List;

public interface DataRegisterMapper {
    int deleteByPrimaryKey(Integer registerId);

    int insert(DataRegister record);

    int insertSelective(DataRegister record);

    DataRegister selectByPrimaryKey(Integer registerId);

    int updateByPrimaryKeySelective(DataRegister record);

    int updateByPrimaryKey(DataRegister record);

    List<DataRegister> selectPageListByParam(PageParam<DataRegister> pageParam);

    int selectPageListCount(PageParam<DataRegister> pageParam);

    List<DataRegister> updateByPhoneSelective(DataRegister record);

    List<DataRegister> selectStatusCount(int activityInfoId);

    List<DataRegister> selectBySearch(DataRegister record);




}