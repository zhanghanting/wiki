package com.pride.mapper;

import com.pride.domain.ProcessCountCheck;
import com.pride.domain.ProcessCountCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessCountCheckMapper {
    long countByExample(ProcessCountCheckExample example);

    int deleteByExample(ProcessCountCheckExample example);

    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    List<ProcessCountCheck> selectByExample(ProcessCountCheckExample example);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByExampleSelective(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByExample(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);
}