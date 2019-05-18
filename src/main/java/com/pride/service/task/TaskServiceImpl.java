package com.pride.service.task;

import com.pride.domain.Task;
import com.pride.domain.TaskExample;
import com.pride.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskMapper taskMapper;
    @Override
    public List<Task> viewAllTasks() {
        return taskMapper.selectByExample(new TaskExample());
    }
}
