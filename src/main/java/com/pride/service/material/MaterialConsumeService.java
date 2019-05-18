package com.pride.service.material;

import com.pride.domain.material.MaterialConsume;
import com.pride.domain.MaterialReceive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaterialConsumeService {
    List<MaterialConsume> queryMaterialConsumeList();
}
