package com.pride.controller.employee;

import com.pride.domain.Employee;
import com.pride.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/employee")
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Employee> getData(){
        return employeeService.viewAllEmployee();
    }
}
