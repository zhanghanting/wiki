package com.pride.service.technology;

import com.pride.domain.TechnologyRequirement;
import com.pride.utils.MyPageHelper;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/19 10:54
 */

public interface TechnologyRequirementService {
    MyPageHelper getList(int page, int rows, TechnologyRequirement technologyRequirement);
}
