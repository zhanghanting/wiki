package com.pride.service.technology;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Technology;
import com.pride.domain.TechnologyExample;
import com.pride.domain.TechnologyRequirement;
import com.pride.domain.vo.TechnologyRequirementVO;
import com.pride.mapper.TechnologyMapper;
import com.pride.mapper.TechnologyRequirementMapper;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/19 10:54
 */

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService{


    @Autowired
    TechnologyMapper technologyMapper;

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public MyPageHelper getList(int page, int rows, TechnologyRequirement technologyRequirement) {
        //分页处理
        PageHelper.startPage(page,rows);
        List<TechnologyRequirementVO> requirementVOList= technologyRequirementMapper.find(technologyRequirement);

        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(requirementVOList);

        //取记录总条数
        PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>();
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public TechnologyRequirement get(String technologyRequirementId) {
        return technologyRequirementMapper.selectByPrimaryKey(technologyRequirementId);
    }

    @Override
    public JsonUtil insert(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.insert(technologyRequirement);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return JsonUtil.build(101, "新增工艺要求信息失败");
        }
    }

    @Override
    public List<Technology> find() {
        TechnologyExample example = new TechnologyExample();
        return technologyMapper.selectByExample(example);
    }

    @Override
    public JsonUtil updateAll(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKey(technologyRequirement);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return JsonUtil.build(101, "修改工艺要求信息失败");
        }
    }

    @Override
    public JsonUtil updateRequirement(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateRequirement(technologyRequirement);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return JsonUtil.build(101, "修改工艺要求失败");
        }
    }

    @Override
    public JsonUtil deleteBatch(String[] ids) {
        int i = technologyRequirementMapper.deleteBatch(ids);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return null;
        }
    }

    @Override
    public MyPageHelper searchTechnologyRequirementByTechnologyRequirementId(Integer page, Integer rows, String technologyRequirementId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<TechnologyRequirementVO> list = technologyRequirementMapper.
                searchTechnologyRequirementByTechnologyRequirementId(technologyRequirementId);
        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(list);
        //取记录总条数
        PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public MyPageHelper searchTechnologyRequirementByTechnologyName(Integer page, Integer rows, String technologyName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<TechnologyRequirementVO> list = technologyRequirementMapper.
                searchTechnologyRequirementByTechnologyName(technologyName);
        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper<>();
        result.setRows(list);
        //取记录总条数
        PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
