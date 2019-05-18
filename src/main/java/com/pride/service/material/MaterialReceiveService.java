package com.pride.service.material;

import com.pride.domain.material.MaterialReceive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaterialReceiveService {

    List<MaterialReceive> queryMaterialReceiveList();
}
