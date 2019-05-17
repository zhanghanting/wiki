package com.pride.service;

import com.pride.domain.Corder;
import com.pride.mapper.CorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorderService {

    @Autowired
    CorderMapper corderMapper;

    public List<Corder> queryCorders() {
        return corderMapper.selectAllCorder();
    }
}
