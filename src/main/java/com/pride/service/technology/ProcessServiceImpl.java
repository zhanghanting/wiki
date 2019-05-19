package com.pride.service.technology;
import com.pride.domain.Process;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.ProcessExample;
import com.pride.mapper.ProcessMapper;
import com.pride.mapper.TechnologyPlanMapper;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/19 17:58
 */

@Service
public class ProcessServiceImpl implements ProcessService{
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Autowired
    ProcessMapper processMapper;

    @Override
    public MyPageHelper getList(Integer page, Integer rows, Process process) {
        //查询商品列表
        ProcessExample example = new ProcessExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<Process> list = processMapper.selectByExample(example);
        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(list);
        //取记录总条数
        PageInfo<Process> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public List<Process> find() {
        ProcessExample example = new ProcessExample();
        return processMapper.selectByExample(example);
    }

    @Override
    public Process get(String processId) {
        return processMapper.selectByPrimaryKey(processId);
    }

    @Override
    public JsonUtil insert(Process process) {
        int i = processMapper.insert(process);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return JsonUtil.build(101, "新增工序信息失败");
        }
    }

    @Override
    public JsonUtil deleteBatch(String[] ids) {
        int i = processMapper.deleteBatch(ids);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return null;
        }
    }

    @Override
    public MyPageHelper searchProcessByProcessId(Integer page, Integer rows, String processId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Process> list = processMapper.searchProcessByProcessId(processId);
        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(list);
        //取记录总条数
        PageInfo<Process> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public MyPageHelper searchProcessByTechnologyPlanId(Integer page, Integer rows, String technologyPlanId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Process> list = processMapper.searchProcessByTechnologyPlanId(technologyPlanId);
        //创建一个返回值对象
        MyPageHelper result = new MyPageHelper();
        result.setRows(list);
        //取记录总条数
        PageInfo<Process> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }


    @Override
    public JsonUtil updateAll(Process process) {
        int i = processMapper.updateByPrimaryKey(process);
        if(i>0){
            return JsonUtil.ok();
        }else{
            return JsonUtil.build(101, "修改工序信息失败");
        }
    }
}
