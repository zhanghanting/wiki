package com.pride.service.material;

import com.pride.domain.Material;

import java.util.List;

public interface MaterialService {
    boolean insertMaterial(Material material);
    List<Material> queryMaterialList();
}
