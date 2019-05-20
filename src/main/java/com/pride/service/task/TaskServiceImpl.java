package com.pride.service.task;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Task;
import com.pride.domain.TaskExample;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.TaskMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskMapper taskMapper;

    @ResponseBody
    @Override
    public List<Task> viewAllTasks() {
        return taskMapper.selectByExample(new TaskExample());
    }

    @ResponseBody
    @Override
    public MyPageHelper<Task> viewPageTasks(Integer page,Integer rows){
        PageHelper.startPage(page,rows);
        List<Task> tasks = taskMapper.selectByExample(new TaskExample());
        PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        MyPageHelper<Task> pageHelper = new MyPageHelper<>();
        pageHelper.setTotal(pageInfo.getTotal());
        pageHelper.setRows(tasks);
        return pageHelper;
    }

    @Override
    public TypeCode updateByModel(Task task) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            taskMapper.updateByPrimaryKey(task);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
    }

    @Override
    public TypeCode deleteTasksByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                taskMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
    }

    @Override
    public TypeCode insertProduct(Task task) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            taskMapper.insert(task);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
    }

    @Override
    public MyPageHelper<Task> searchTask(String taskId,String taskWorkId,String taskManufactureSn,Integer page, Integer rows) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        if(taskId != null) {
            criteria.andTaskIdLike("%" + taskId + "%");
        }
        if(taskWorkId != null) {
            criteria.andWorkIdLike("%" + taskWorkId + "%");
        }
        if(taskManufactureSn != null) {
            criteria.andManufactureSnLike("%" + taskManufactureSn + "%");
        }
        PageHelper.startPage(page,rows);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        MyPageHelper<Task> pageHelper = new MyPageHelper<>();
        pageHelper.setRows(tasks);
        pageHelper.setTotal(pageInfo.getSize());
        return pageHelper;
    }
}
