package com.pride.service.material;




import com.pride.mapper.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pride.domain.material.MaterialReceive;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService{

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;
    @Override
    public List<MaterialReceive> queryMaterialReceiveList() {
        List<MaterialReceive> materialReceive = materialReceiveMapper.queryMaterialReceiveList();
        return materialReceive;
    }
}
