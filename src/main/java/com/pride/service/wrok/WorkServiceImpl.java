package com.pride.service.wrok;

import com.pride.domain.work.WorkPageType;
import com.pride.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{
    @Autowired
    WorkMapper workMapper;

    @Override
    public List<WorkPageType> viewAllWorks() {
        return workMapper.viewAllWorks();
    }
}
