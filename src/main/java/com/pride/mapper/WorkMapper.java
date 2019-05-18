package com.pride.mapper;

import com.pride.domain.Work;
import com.pride.domain.WorkExample;
import java.util.List;

import com.pride.domain.work.WorkPageType;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {

    List<WorkPageType> viewAllWorks();

    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}