package com.pride.mapper;

import com.pride.domain.TechnologyRequirement;
import com.pride.domain.TechnologyRequirementExample;
import java.util.List;

import com.pride.domain.vo.TechnologyRequirementVO;
import org.apache.ibatis.annotations.Param;

public interface TechnologyRequirementMapper {

    //逆向工程生成的mapper接口
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);


    //扩展的mapper接口方法
    int updateRequirement(TechnologyRequirement technologyRequirement);

    List<TechnologyRequirementVO> find(TechnologyRequirement technologyRequirement);

    int deleteBatch(String[] ids);

    List<TechnologyRequirementVO> searchTechnologyRequirementByTechnologyRequirementId(
            String technologyRequirementId);

    List<TechnologyRequirementVO> searchTechnologyRequirementByTechnologyName(
            String technologyName);
}