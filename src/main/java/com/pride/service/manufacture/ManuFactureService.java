package com.pride.service.manufacture;

import com.pride.domain.Manufacture;
import com.pride.domain.manufacture.ManufacturePageType;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface ManuFactureService {
    MyPageHelper<ManufacturePageType> viewPageManufacturePageType(Integer page, Integer rows);
}
