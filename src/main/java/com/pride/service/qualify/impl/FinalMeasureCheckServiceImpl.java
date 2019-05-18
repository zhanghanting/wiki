package com.pride.service.qualify.impl;

import com.pride.domain.vo.FinalMeasureCheckVO;
import com.pride.mapper.FinalMeasuretCheckMapper;
import com.pride.service.qualify.FinalMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FinalMeasureCheckServiceImpl implements FinalMeasureCheckService
{
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;
    @Override
    public List<FinalMeasureCheckVO> queryFinalMeasureCheckVO()
    {
        List<FinalMeasureCheckVO> finalMeasureCheckVOS = finalMeasuretCheckMapper.find();
        return finalMeasureCheckVOS;
    }
}
