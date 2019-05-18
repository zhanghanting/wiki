package com.pride.service.material;

import com.pride.domain.Material;
import com.pride.domain.MaterialConsume;
import com.pride.mapper.MaterialMapper;
import com.pride.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;
    @Override
    public boolean insertMaterial(Material material) {
        int insert = materialMapper.insert(material);
        return insert!=0;
    }
    @Override
    public List<Material> queryMaterialList() {
        List<Material> materials = materialMapper.queryMaterialList();
        return materials;
    }

}
