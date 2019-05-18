package com.pride.mapper;

import com.pride.domain.Technology;
import com.pride.domain.TechnologyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyMapper {


    //扩展的mapper接口
    int deleteBatch(String[] ids);
    List<Technology> searchTechnologyByTechnologyId(String technologyId);
    List<Technology> searchTechnologyByTechnologyName(String technologyName);



    //逆向工程生产的mapper接口
    long countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);
}