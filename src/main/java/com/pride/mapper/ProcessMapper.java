package com.pride.mapper;

import com.pride.domain.Process;
import com.pride.domain.ProcessExample;
import java.util.List;

import com.pride.domain.Product;
import org.apache.ibatis.annotations.Param;

public interface ProcessMapper {
    long countByExample(ProcessExample example);

    int deleteByExample(ProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    List<Process> selectByExample(ProcessExample example);

    Process selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByExample(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);


    //扩展的mapper接口方法
    int deleteBatch(String[] ids);

    List<Process> searchProcessByProcessId(String processId);

    List<Process> searchProcessByTechnologyPlanId(String technologyPlanId);
}