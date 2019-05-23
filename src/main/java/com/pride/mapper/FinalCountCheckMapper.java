package com.pride.mapper;

import com.pride.domain.FinalCountCheck;
import com.pride.domain.FinalCountCheckExample;
import java.util.List;

import com.pride.domain.vo.FinalCountCheckVO;
import org.apache.ibatis.annotations.Param;

public interface FinalCountCheckMapper {
    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
    List<FinalCountCheckVO> find();

    int deleteBatch(String[] ids);

    List<FinalCountCheckVO> searchFCountCheckByOrderId(String searchValue);

    int updateNote(FinalCountCheck finalCountCheck);

    List<FinalCountCheckVO> searchFCountCheckByFCountCheckId(String searchValue);
}