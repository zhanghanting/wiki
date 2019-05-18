package com.pride.service.task;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Task;
import com.pride.domain.TaskExample;
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
}
