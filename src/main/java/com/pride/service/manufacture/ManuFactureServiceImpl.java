package com.pride.service.manufacture;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Manufacture;
import com.pride.domain.manufacture.ManufacturePageType;
import com.pride.mapper.ManufactureMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Service
public class ManuFactureServiceImpl implements ManuFactureService{

    @Autowired
    ManufactureMapper manufactureMapper;

    // 返回分页的ManufacturePageType的List
    // json
    @ResponseBody
    @Override
    public MyPageHelper<ManufacturePageType> viewPageManufacturePageType(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<ManufacturePageType> manufacturePageTypes = manufactureMapper.viewAllManufacturePageType();
        PageInfo<ManufacturePageType> pageInfo = new PageInfo<>(manufacturePageTypes);
        MyPageHelper<ManufacturePageType> pageHelper = new MyPageHelper<>();
        pageHelper.setRows(manufacturePageTypes);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }
}
