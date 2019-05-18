package com.pride.service.material;

import com.pride.domain.material.MaterialConsume;

import com.pride.mapper.MaterialConsumeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService{

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;
    @Override
    public List<MaterialConsume> queryMaterialConsumeList() {
        List<MaterialConsume> materialConsumes = materialConsumeMapper.queryMaterialConsumeList();
        return materialConsumes;
    }
}
