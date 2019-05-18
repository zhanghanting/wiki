package com.pride.service.qualify.impl;

import com.pride.domain.vo.ProcessCountCheckVO;
import com.pride.domain.vo.ProcessMeasureCheckVO;
import com.pride.mapper.ProcessCountCheckMapper;
import com.pride.service.qualify.ProcessCountCheckService;
import com.pride.service.qualify.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService
{
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Override
    public List<ProcessCountCheckVO> queryProcessCountCheckVO()
    {
        List<ProcessCountCheckVO> processCountCheckVOS = processCountCheckMapper.find();
        return processCountCheckVOS;
    }
}
