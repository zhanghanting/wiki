package com.pride.service.material;

import com.pride.domain.Material;
import com.pride.domain.material.MaterialReceive;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public interface MaterialReceiveService {

    List<MaterialReceive> queryMaterialReceiveList();

    MyPageHelper queryMaterialReceiveList(Integer page, Integer rows);

    MaterialReceive queryMaterialReceiveById(String id);

    JsonUtil insertMaterialReceive(MaterialReceive materialReceive, BindingResult bindingResult);

    JsonUtil editMaterialReceive(MaterialReceive materialReceive, BindingResult bindingResult);

    boolean deleteBatch(String[] ids);
}
