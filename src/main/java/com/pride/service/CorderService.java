package com.pride.service;

import com.pride.domain.Corder;
import com.pride.mapper.CorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorderService {

    @Autowired
    CorderMapper corderMapper;

    public List<Corder> queryCorders() {
        List<Corder> corders = new ArrayList<Corder>();
                corders.add(corderMapper.selectByPrimaryKey("000001"));
        return corders;
    }
}
