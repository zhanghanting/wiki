package com.pride.service.task;

import com.pride.domain.Task;
import com.pride.domain.typecode.TypeCode;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface TaskService {
    List<Task> viewAllTasks();
    MyPageHelper<Task> viewPageTasks(Integer page, Integer rows);

    TypeCode updateByModel(Task task);

    TypeCode deleteTasksByIds(String[] ids);

    TypeCode insertProduct(Task task);

    MyPageHelper<Task> searchTask(String taskId,String taskWorkId,String taskManufactureSn,Integer page, Integer rows);

}
