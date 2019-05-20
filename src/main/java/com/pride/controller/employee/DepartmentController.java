package com.pride.controller.employee;

import com.pride.domain.Department;
import com.pride.domain.Employee;
import com.pride.service.employee.DepartmentService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/erp/department")
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/get/{departmentId}")
    @ResponseBody
    public Department getItemById(@PathVariable String departmentId) throws Exception{
        Department department = departmentService.get(departmentId);
        return department;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "department_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Department> getData() throws Exception{
        return departmentService.getData();
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "department_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "department_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    private MyPageHelper getList(int page,int rows)
    {
        return departmentService.getList(page,rows);
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private JsonUtil insert(@Valid Department department,BindingResult bindingResult)
    {
        JsonUtil result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }

        if (departmentService.get(department.getDepartmentId()) != null)
        {
            result =  JsonUtil.build(0,"部门已存在！",null);
        }
        else
            result = departmentService.insert(department);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/update_all")
    private JsonUtil updateAll(@Valid Department department,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return departmentService.updateAll(department);
    }

}
