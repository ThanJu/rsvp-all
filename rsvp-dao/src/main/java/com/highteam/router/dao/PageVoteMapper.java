package com.highteam.router.dao;

import com.highteam.router.model.PageVote;

public interface PageVoteMapper {
    int deleteByPrimaryKey(Integer pageVoteId);

    int insert(PageVote record);

    int insertSelective(PageVote record);

    PageVote selectByPrimaryKey(Integer pageVoteId);

    int updateByPrimaryKeySelective(PageVote record);

    int updateByPrimaryKey(PageVote record);
}