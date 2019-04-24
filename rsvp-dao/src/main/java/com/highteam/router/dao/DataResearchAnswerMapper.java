package com.highteam.router.dao;

import com.highteam.router.model.DataResearchAnswer;

public interface DataResearchAnswerMapper {
    int deleteByPrimaryKey(Integer answerId);

    int insert(DataResearchAnswer record);

    int insertSelective(DataResearchAnswer record);

    DataResearchAnswer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(DataResearchAnswer record);

    int updateByPrimaryKey(DataResearchAnswer record);
}