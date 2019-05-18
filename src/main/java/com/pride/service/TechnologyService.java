package com.pride.service;

import com.pride.domain.Technology;
import com.pride.domain.customize.EUDataGridResult;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/17 20:34
 */

public interface TechnologyService {
    List<Technology> find();

    Technology get(String string);

    EUDataGridResult searchTechnologyByTechnologyId(Integer page, Integer rows, String searchValue);

    EUDataGridResult searchTechnologyByTechnologyName(Integer page, Integer rows, String searchValue);
}
