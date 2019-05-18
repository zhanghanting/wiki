package com.pride.controller.task;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Task;
import com.pride.service.task.TaskService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/task/")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping("find")
    public String find(){
        return "task_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public MyPageHelper<Task> list(Integer page,Integer rows){
        PageHelper.startPage(page,rows);
        List<Task> tasks = taskService.viewAllTasks();
        PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        MyPageHelper<Task> pageHelper = new MyPageHelper<>();
        pageHelper.setTotal(pageInfo.getTotal());
        pageHelper.setRows(tasks);
        return pageHelper;
    }
}
