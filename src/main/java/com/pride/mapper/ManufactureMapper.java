package com.pride.mapper;

import com.pride.domain.Manufacture;
import com.pride.domain.ManufactureExample;
import java.util.List;

import com.pride.domain.manufacture.ManufacturePageType;
import org.apache.ibatis.annotations.Param;

public interface ManufactureMapper {
    List<ManufacturePageType> viewAllManufacturePageType();

    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);
}