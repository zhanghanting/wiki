package com.pride.service.manufacture;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Manufacture;
import com.pride.domain.ManufactureExample;
import com.pride.domain.manufacture.ManufacturePageType;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.CorderMapper;
import com.pride.mapper.ManufactureMapper;
import com.pride.mapper.ManufacturePageTypeMapper;
import com.pride.mapper.TechnologyMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class ManuFactureServiceImpl implements ManuFactureService{

    @Autowired
    ManufactureMapper manufactureMapper;
    @Autowired
    ManufacturePageTypeMapper manufacturePageTypeMapper;
    @Autowired
    CorderMapper corderMapper;
    @Autowired
    TechnologyMapper technologyMapper;

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

    @Override
    public TypeCode updateByModel(Manufacture manufacture) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            manufactureMapper.updateByPrimaryKey(manufacture);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
}

    @Override
    public TypeCode deleteManufacturesByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                manufactureMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
    }

    @Override
    public TypeCode insertManufacture(Manufacture manufacture) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            manufactureMapper.insert(manufacture);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
    }

    @Override
    public MyPageHelper<ManufacturePageType> searchManufactureByManufactureId(String searchValue, Integer page, Integer rows) {
        ManufactureExample manufactureExample = new ManufactureExample();
        ManufactureExample.Criteria criteria = manufactureExample.createCriteria();
        criteria.andManufactureSnLike("%" + searchValue + "%");
        PageHelper.startPage(page,rows);
        List<ManufacturePageType> manufacturePageTypes = viewSearchPage(manufactureExample);
        PageInfo<ManufacturePageType> pageInfo = new PageInfo<>(manufacturePageTypes);
        MyPageHelper<ManufacturePageType> pageHelper = new MyPageHelper<>();
        pageHelper.setRows(manufacturePageTypes);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }

    @Override
    public MyPageHelper<ManufacturePageType> searchManufactureByManufactureOrderId(String searchValue, Integer page, Integer rows) {
        ManufactureExample manufactureExample = new ManufactureExample();
        ManufactureExample.Criteria criteria = manufactureExample.createCriteria();
        criteria.andOrderIdLike("%" + searchValue + "%");
        PageHelper.startPage(page,rows);
        List<ManufacturePageType> manufacturePageTypes = viewSearchPage(manufactureExample);
        PageInfo<ManufacturePageType> pageInfo = new PageInfo<>(manufacturePageTypes);
        MyPageHelper<ManufacturePageType> pageHelper = new MyPageHelper<>();
        pageHelper.setRows(manufacturePageTypes);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }

    @Override
    public MyPageHelper<ManufacturePageType> searchManufactureByManufactureTechnologyName(String searchValue, Integer page, Integer rows) {
        searchValue = "'%" + searchValue + "%'";
        PageHelper.startPage(page,rows);
        List<ManufacturePageType> manufacturePageTypes = manufacturePageTypeMapper.searchManufactureByManufactureTechnologyName(searchValue);
        PageInfo<ManufacturePageType> pageInfo = new PageInfo<>(manufacturePageTypes);
        MyPageHelper<ManufacturePageType> pageHelper = new MyPageHelper<>();
        pageHelper.setTotal(pageInfo.getTotal());
        pageHelper.setRows(manufacturePageTypes);
        return pageHelper;
    }

    @Override
    public List<Manufacture> viewAllManufactures() {
        return manufactureMapper.selectByExample(new ManufactureExample());
    }


    private List<ManufacturePageType> viewSearchPage(ManufactureExample manufactureExample) {
        List<Manufacture> manufactures = manufactureMapper.selectByExample(manufactureExample);
        List<ManufacturePageType> manufacturePageTypes = new ArrayList<>();
        for (Manufacture manufacture : manufactures) {
            ManufacturePageType manufacturePageType = new ManufacturePageType();
            manufacturePageType.buildManufacture(manufacture);
            manufacturePageType.setcOrder(corderMapper.selectByPrimaryKey(manufacture.getOrderId()));
            manufacturePageType.setTechnology(technologyMapper.selectByPrimaryKey(manufacture.getTechnologyId()));
            manufacturePageTypes.add(manufacturePageType);
        }
        return manufacturePageTypes;
    }
}
