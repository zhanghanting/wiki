package com.pride.service.order;

import com.pride.domain.Corder;
import com.pride.domain.CorderExample;
import com.pride.mapper.CorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorderService {

    @Autowired
    CorderMapper corderMapper;

    public List<Corder> queryCorders() {
        return corderMapper.selectByExample(new CorderExample());
    }
}
