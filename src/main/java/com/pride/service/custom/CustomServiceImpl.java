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
    @Override
    public List<Custom> viewAllCustoms() {
        return customMapper.selectByExample(new CustomExample());
    }

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

    @Override
    public MyPageHelper<Custom> searchCustomByCustomId(String searchValue, Integer page, Integer rows) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdLike("%" + searchValue + "%");
        return viewSearch(customExample,page,rows);
    }

    @Override
    public MyPageHelper<Custom> searchCustomByCustomName(String searchValue, Integer page, Integer rows) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomNameLike("%" + searchValue + "%");
        return viewSearch(customExample,page,rows);
    }

    private MyPageHelper<Custom> viewSearch(CustomExample customExample,Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        List<Custom> customs = customMapper.selectByExample(customExample);
        PageInfo<Custom> pageInfo = new PageInfo<>(customs);
        MyPageHelper<Custom> pageHelper = new MyPageHelper<>();
        pageHelper.setRows(customs);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }
}
