package com.pride.service.material;

import com.pride.domain.Material;
import com.pride.domain.material.MaterialConsume;
import com.pride.domain.material.MaterialReceive;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public interface MaterialConsumeService {
    List<MaterialConsume> queryMaterialConsumeList();

    MyPageHelper queryMaterialConsumeList(Integer page, Integer rows);

    MaterialConsume queryMaterialConsumeById(String id);

    JsonUtil insertMaterialConsume(MaterialConsume materialConsume, BindingResult bindingResult);

    JsonUtil editMaterialConsume(MaterialConsume materialConsume, BindingResult bindingResult);

    boolean deleteBatch(String[] ids);
}
