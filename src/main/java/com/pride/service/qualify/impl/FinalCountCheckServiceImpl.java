package com.pride.service.qualify.impl;

import com.pride.domain.vo.FinalCountCheckVO;
import com.pride.mapper.FinalCountCheckMapper;
import com.pride.service.qualify.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService
{
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    @Override
    public List<FinalCountCheckVO> queryFinalCountCheckVO()
    {
        List<FinalCountCheckVO> finalCountCheckVOS = finalCountCheckMapper.find();
        return finalCountCheckVOS;
    }
}
