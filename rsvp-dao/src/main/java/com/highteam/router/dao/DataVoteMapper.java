package com.highteam.router.dao;

import com.highteam.router.model.DataVote;

public interface DataVoteMapper {
    int deleteByPrimaryKey(Integer dataVoteId);

    int insert(DataVote record);

    int insertSelective(DataVote record);

    DataVote selectByPrimaryKey(Integer dataVoteId);

    int updateByPrimaryKeySelective(DataVote record);

    int updateByPrimaryKey(DataVote record);
}