package com.pride.service.technology;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.TechnologyPlan;
import com.pride.domain.TechnologyPlanExample;
import com.pride.domain.vo.TechnologyPlanVO;
import com.pride.mapper.TechnologyMapper;
import com.pride.mapper.TechnologyPlanMapper;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/19 17:57
 */

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {


    @Autowired
    TechnologyMapper technologyMapper;

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;


    @Override
    public TechnologyPlan get(String technologyPlanId) {
        return technologyPlanMapper.selectByPrimaryKey(technologyPlanId);
    }

    @Override
    public MyPageHelper getList(Integer page, Integer rows, TechnologyPlanVO technologyPlanPO) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> list = technologyPlanMapper.find(technologyPlanPO);
        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(list);
        //取记录总条数
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public JsonUtil insert(TechnologyPlan technologyPlan) {
        int i = technologyPlanMapper.insert(technologyPlan);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return JsonUtil.build(101, "新增工艺计划信息失败");
        }
    }

    @Override
    public JsonUtil deleteBatch(String[] ids) {
        int i = technologyPlanMapper.deleteBatch(ids);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return null;
        }
    }

    @Override
    public JsonUtil updateAll(TechnologyPlan technologyPlan) {
        int i = technologyPlanMapper.updateByPrimaryKey(technologyPlan);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return JsonUtil.build(101, "修改工艺计划信息失败");
        }
    }

    @Override
    public MyPageHelper searchTechnologyPlanByTechnologyName(Integer page, Integer rows, String technologyName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> list = technologyPlanMapper
                .searchTechnologyPlanByTechnologyName(technologyName);
        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(list);
        //取记录总条数
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public MyPageHelper searchTechnologyPlanByTechnologyPlanId(Integer page, Integer rows, String technologyPlanId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> list = technologyPlanMapper
                .searchTechnologyPlanByTechnologyPlanId(technologyPlanId);
        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(list);
        //取记录总条数
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public List<TechnologyPlan> find() {
        TechnologyPlanExample example = new TechnologyPlanExample();
        return technologyPlanMapper.selectByExample(example);
    }
}
