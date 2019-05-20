package com.pride.service.employee;

import com.pride.domain.Employee;
import com.pride.domain.vo.EmployeeVO;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface EmployeeService
{
    List<Employee> viewAllEmployee();
    List<EmployeeVO> getList();
    Employee get(String empId);
    EmployeeVO getVO(String emId);

    JsonUtil insert(Employee employee);

    JsonUtil updateAll(Employee employee);

    MyPageHelper getList(int page,int rows);
}
