package com.pride.service.qualify.impl;

import com.pride.domain.vo.ProcessMeasureCheckVO;
import com.pride.mapper.ProcessMeasureCheckMapper;
import com.pride.service.qualify.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService
{
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;
    @Override
    public List<ProcessMeasureCheckVO> queryProcessMeasureCheckVO()
    {
        List<ProcessMeasureCheckVO> processMeasureCheckVOS = processMeasureCheckMapper.find();
        return processMeasureCheckVOS;
    }
}
