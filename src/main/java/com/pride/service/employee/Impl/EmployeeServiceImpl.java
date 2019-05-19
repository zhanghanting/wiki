package com.pride.service.employee.Impl;

import com.pride.domain.Employee;
import com.pride.domain.EmployeeExample;
import com.pride.mapper.EmployeeMapper;
import com.pride.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<Employee> viewAllEmployee()
    {
        List<Employee> employees = employeeMapper.selectByExample(new EmployeeExample());
        return  employees;
    }
}
