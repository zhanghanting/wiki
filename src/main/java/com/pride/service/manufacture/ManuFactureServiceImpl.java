package com.pride.service.manufacture;

import com.pride.domain.manufacture.ManufacturePageType;
import com.pride.mapper.ManufactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManuFactureServiceImpl implements ManuFactureService{

    @Autowired
    ManufactureMapper manufactureMapper;
    @Override
    public List<ManufacturePageType> viewAllManufacturePageType() {
        return manufactureMapper.viewAllManufacturePageType();
    }
}
