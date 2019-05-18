package com.pride.service.material;

import com.pride.domain.Material;
import com.pride.domain.MaterialConsume;

import java.util.List;

public interface MaterialService {
    //物料信息控制
    boolean insertMaterial(Material material);
    List<Material> queryMaterialList();

}
