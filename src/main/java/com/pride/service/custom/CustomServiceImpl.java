package com.pride.service.custom;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Custom;
import com.pride.domain.CustomExample;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.CustomMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomMapper customMapper;

    // 返回分页的Custom的List
    // json
    @ResponseBody
    @Override
    public MyPageHelper<Custom> viewPageCustoms(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<Custom> customs =customMapper.selectByExample(new CustomExample());
        PageInfo<Custom> PageInfo = new PageInfo<>(customs);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setRows(customs);
        pageHelper.setTotal(PageInfo.getTotal());
        return pageHelper;
    }

    // 通过id修改custom
    @Override
    public Custom selectCustomById(String id) {
        return customMapper.selectByPrimaryKey(id);
    }

    // 返回所有Custom的List
    // json
    @ResponseBody
    @Override
    public List<Custom> viewAllCustoms() {
        return customMapper.selectByExample(new CustomExample());
    }

    @ResponseBody
    @Override
    public TypeCode insertCustom(Custom custom) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            customMapper.insert(custom);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }


    @ResponseBody
    @Override
    public TypeCode deleteCustomsByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                customMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }
}
