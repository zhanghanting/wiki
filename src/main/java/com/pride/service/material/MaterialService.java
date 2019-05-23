package com.pride.service.material;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Material;
import com.pride.domain.MaterialConsume;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;

public interface MaterialService {
    //物料信息控制
    boolean insertMaterial(Material material);

    Material queryMaterialById(String id);

    MyPageHelper queryMaterialList(Integer page, Integer rows);

    List<Material> queryMaterialList();

    JsonUtil insertMaterial(Material material, BindingResult bindingResult);

    JsonUtil editMaterial(Material material, BindingResult bindingResult);

    boolean deleteBatch(String[] ids);
}
