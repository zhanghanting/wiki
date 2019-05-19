package com.pride.service.technology;

import com.pride.domain.Technology;
import com.pride.domain.TechnologyRequirement;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/19 10:54
 */

public interface TechnologyRequirementService {
    MyPageHelper getList(int page, int rows, TechnologyRequirement technologyRequirement);

    TechnologyRequirement get(String technologyRequirementId);

    JsonUtil insert(TechnologyRequirement technologyRequirement);

    List<Technology> find();

    JsonUtil updateAll(TechnologyRequirement technologyRequirement);

    JsonUtil updateRequirement(TechnologyRequirement technologyRequirement);

    JsonUtil deleteBatch(String[] ids);

    MyPageHelper searchTechnologyRequirementByTechnologyRequirementId(Integer page, Integer rows, String searchValue);

    MyPageHelper searchTechnologyRequirementByTechnologyName(Integer page, Integer rows, String searchValue);
}
