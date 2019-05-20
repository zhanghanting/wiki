package com.pride.mapper;

import com.pride.domain.manufacture.ManufacturePageType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufacturePageTypeMapper {
    List<ManufacturePageType> searchManufactureByManufactureOrderId(@Param("searchValue") String searchValue);


    List<ManufacturePageType> searchManufactureByManufactureTechnologyName(@Param("searchValue")String searchValue);
}
