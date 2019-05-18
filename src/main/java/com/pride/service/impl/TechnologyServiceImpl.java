package com.pride.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Technology;
import com.pride.domain.TechnologyExample;

import com.pride.mapper.TechnologyMapper;
import com.pride.service.TechnologyService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/17 21:47
 */

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public List<Technology> find() {
        TechnologyExample example = new TechnologyExample();
        return technologyMapper.selectByExample(example);
    }

    @Override
    public Technology get(String string) {
        return technologyMapper.selectByPrimaryKey(string);
    }

    @Override
    public MyPageHelper getList(int page, int rows, Technology technology) {
       //查询工艺列表
        TechnologyExample technologyExample = new TechnologyExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<Technology> technologyList = technologyMapper.selectByExample(technologyExample);

        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(technologyList);

        //取总记录数
        PageInfo<Technology> pageInfo = new PageInfo<>(technologyList);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public JsonUtil insert(Technology technology) {
        int i = technologyMapper.insert(technology);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return JsonUtil.build(101, "新增工艺信息失败");
        }
    }

    @Override
    public JsonUtil deleteBatch(String[] ids) {

        int i = technologyMapper.deleteBatch(ids);
        if (i > 0){
            return JsonUtil.ok();
        } else {
            return null;
        }
    }

    @Override
    public JsonUtil updateAll(Technology technology) {
        int i = technologyMapper.updateByPrimaryKey(technology);
        if (i>0){
            return JsonUtil.ok();
        } else {
            return JsonUtil.build(101,"修改工艺信息失败");
        }
    }

    @Override
    public MyPageHelper searchTechnologyByTechnologyId(Integer page, Integer rows, String technologyId) {
        //分页处理
        PageHelper.startPage(page,rows);
        List<Technology> technologyList = technologyMapper.searchTechnologyByTechnologyId(technologyId);

        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(technologyList);

        //取总记录数
        PageInfo<Technology> pageInfo = new PageInfo<>(technologyList);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public MyPageHelper searchTechnologyByTechnologyName(Integer page, Integer rows, String technologyName) {
        //分页处理
        PageHelper.startPage(page,rows);
        List<Technology> technologyList = technologyMapper.searchTechnologyByTechnologyName(technologyName);

        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(technologyList);

        //取总记录数
        PageInfo<Technology> pageInfo = new PageInfo<>(technologyList);
        result.setTotal(pageInfo.getTotal());

        return result;
    }
}
