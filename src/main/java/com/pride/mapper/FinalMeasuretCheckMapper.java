package com.pride.mapper;

import com.pride.domain.FinalMeasuretCheck;
import com.pride.domain.FinalMeasuretCheckExample;
import java.util.List;

import com.pride.domain.vo.FinalMeasureCheckVO;
import org.apache.ibatis.annotations.Param;

public interface FinalMeasuretCheckMapper {
    long countByExample(FinalMeasuretCheckExample example);

    int deleteByExample(FinalMeasuretCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByExample(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);
    List<FinalMeasureCheckVO> find();

    int deleteBatch(String[] ids);

    List<FinalMeasureCheckVO> searchFMeasureCheckByfMeasureCheckId(String searchValue);

    List<FinalMeasureCheckVO> searchFMeasureCheckByOrderId(String searchValue);

    int updateNote(FinalMeasuretCheck finalMeasuretCheck);
}