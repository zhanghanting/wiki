package com.pride.service.custom;

import com.pride.domain.Custom;
import com.pride.domain.CustomExample;
import com.pride.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> viewAllCustoms() {
        return customMapper.selectByExample(new CustomExample());
    }
}
