package com.pride.service.manufacture;

import com.pride.domain.Manufacture;
import com.pride.domain.manufacture.ManufacturePageType;
import com.pride.domain.typecode.TypeCode;
import com.pride.utils.MyPageHelper;

import java.util.List;


public interface ManuFactureService {
    MyPageHelper<ManufacturePageType> viewPageManufacturePageType(Integer page, Integer rows);

    TypeCode updateByModel(Manufacture manufacture);

    TypeCode deleteManufacturesByIds(String[] ids);

    TypeCode insertManufacture(Manufacture manufacture);

    MyPageHelper<ManufacturePageType> searchManufactureByManufactureId(String searchValue, Integer page, Integer rows);

    MyPageHelper<ManufacturePageType> searchManufactureByManufactureOrderId(String searchValue, Integer page, Integer rows);

    MyPageHelper<ManufacturePageType> searchManufactureByManufactureTechnologyName(String searchValue, Integer page, Integer rows);

    List<Manufacture> viewAllManufactures();
}
