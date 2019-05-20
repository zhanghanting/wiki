package com.pride.service.technology;

import com.pride.domain.TechnologyPlan;
import com.pride.domain.vo.TechnologyPlanVO;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/19 17:57
 */

public interface TechnologyPlanService {
    TechnologyPlan get(String technologyPlanId);

    MyPageHelper getList(Integer page, Integer rows, TechnologyPlanVO technologyPlanPO);

    JsonUtil insert(TechnologyPlan technologyPlan);

    JsonUtil deleteBatch(String[] ids);

    JsonUtil updateAll(TechnologyPlan technologyPlan);

    MyPageHelper searchTechnologyPlanByTechnologyName(Integer page, Integer rows, String searchValue);

    MyPageHelper searchTechnologyPlanByTechnologyPlanId(Integer page, Integer rows, String searchValue);

    List<TechnologyPlan> find();
}