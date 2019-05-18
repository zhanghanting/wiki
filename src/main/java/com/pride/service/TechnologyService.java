package com.pride.service;

import com.pride.domain.Technology;

import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/17 20:34
 */

public interface TechnologyService {
    List<Technology> find();

    Technology get(String string);

    MyPageHelper searchTechnologyByTechnologyId(Integer page, Integer rows, String searchValue);

    MyPageHelper searchTechnologyByTechnologyName(Integer page, Integer rows, String searchValue);

    MyPageHelper getList(int page, int rows, Technology technology);

    JsonUtil insert(Technology technology);

    JsonUtil deleteBatch(String[] ids);

    JsonUtil updateAll(Technology technology);
}
