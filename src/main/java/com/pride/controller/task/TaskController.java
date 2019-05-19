package com.pride.controller.task;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Task;
import com.pride.domain.typecode.TypeCode;
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
        return taskService.viewPageTasks(page,rows);
    }
    //返回所有的Task
    @ResponseBody
    @RequestMapping("get_data")
    public List<Task> getData(){
        return taskService.viewAllTasks();
    }
    // 通过生产派工编号模糊查询
    @ResponseBody
    @RequestMapping("search_task_by_taskId")
    public MyPageHelper<Task> searchTaskByTaskId(String searchValue,Integer page, Integer rows){
        return taskService.searchTask(searchValue,null,null,page,rows);
    }
    // 通过作业编号模糊查询
    @ResponseBody
    @RequestMapping("search_task_by_taskWorkId")
    public MyPageHelper<Task> searchTaskByTaskWorkId(String searchValue,Integer page, Integer rows){
        return taskService.searchTask(null,searchValue,null,page,rows);
    }
    // 通过作业编号模糊查询
    @ResponseBody
    @RequestMapping("search_task_by_taskManufactureSn")
    public MyPageHelper<Task> searchTaskByTaskManufactureSn(String searchValue,Integer page, Integer rows){
        return taskService.searchTask(null,null,searchValue,page,rows);
    }


    // 返回空的json
    @ResponseBody
    @RequestMapping("edit_judge")
    public String editJudge(){
        return null;
    }
    // 跳转到task的修改页面
    // json
    @RequestMapping("edit")
    public String edit(){
        return "product_edit";
    }
    // 通过id修改task
    @ResponseBody
    @RequestMapping("update_all")
    public TypeCode updateAll(Task task){
        return taskService.updateByModel(task);
    }



    // 删除请求
    @ResponseBody
    @RequestMapping("delete_judge")
    public String deleteJudge(){
        return null;
    }
    // 通过id的Sring数组删除task
    @ResponseBody
    @RequestMapping("delete_batch")
    public TypeCode deleteBatch(String[] ids){
        return taskService.deleteTasksByIds(ids);
    }






    // 返回空的json字符串
    @ResponseBody
    @RequestMapping("add_judge")
    public String addJudge(){
        return null;
    }
    // 返回product的添加页面
    @RequestMapping("add")
    public String add(){
        return "product_add";
    }
    // 通过id新增一个product实例
    @ResponseBody
    @RequestMapping("insert")
    public TypeCode insert(Task task){
        return taskService.insertProduct(task);
    }
}
