package com.pride.service.employee;

import com.pride.domain.Department;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface DepartmentService
{
    List<Department> getData();
    Department get(String departmentId);

    JsonUtil insert(Department department);

    JsonUtil updateAll(Department department);

    MyPageHelper getList(int page,int rows);
}
