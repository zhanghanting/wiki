package com.pride.service.impl;

import com.pride.domain.Technology;
import com.pride.domain.TechnologyExample;
import com.pride.domain.customize.EUDataGridResult;
import com.pride.mapper.TechnologyMapper;
import com.pride.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/17 21:47
 */

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public List<Technology> find() {
        TechnologyExample example = new TechnologyExample();
        return technologyMapper.selectByExample(example);
    }

    @Override
    public Technology get(String string) {
        return technologyMapper.selectByPrimaryKey(string);
    }

    @Override
    public EUDataGridResult searchTechnologyByTechnologyId(Integer page, Integer rows, String searchValue) {
        return null;
    }

    @Override
    public EUDataGridResult searchTechnologyByTechnologyName(Integer page, Integer rows, String searchValue) {
        return null;
    }
}
