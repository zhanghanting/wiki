package com.pride.service.custom;

import com.pride.domain.Custom;
import com.pride.domain.typecode.TypeCode;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface CustomService {
    MyPageHelper<Custom> viewPageCustoms(Integer page, Integer rows);

    Custom selectCustomById(String id);

    List<Custom> viewAllCustoms();

    TypeCode insertCustom(Custom custom);

    TypeCode deleteCustomsByIds(String[] ids);
}
