package com.pride.service.task;

import com.pride.domain.Task;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface TaskService {
    List<Task> viewAllTasks();
    MyPageHelper<Task> viewPageTasks(Integer page, Integer rows);
}
