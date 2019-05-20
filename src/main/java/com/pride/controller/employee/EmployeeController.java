package com.pride.controller.employee;

import com.pride.domain.Employee;
import com.pride.domain.vo.EmployeeVO;
import com.pride.service.employee.EmployeeService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/erp/employee")
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;
    @ResponseBody
    @RequestMapping("/get/{empId}")
    public EmployeeVO getItemById(@PathVariable String empId)
    {
        EmployeeVO employeeVO = employeeService.getVO(empId);
        return employeeVO;
    }
    @RequestMapping("/find")
    public String find()
    {
        return "employee_list";
    }
    @RequestMapping("/list")
    private MyPageHelper getList(int page,int rows)
    {
        return employeeService.getList(page,rows);
    }
    @ResponseBody
    @RequestMapping("/get_data")
    public List<EmployeeVO> getData(){
        return employeeService.getList();
    }
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String,String> add_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String,String> edit_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String,String> delete_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @RequestMapping("/add")
    public String add()
    {
        return "employee_add";
    }
    @RequestMapping("/edit")
    public String edit()
    {
        return "employee_edit";
    }
    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    private JsonUtil insert(@Valid Employee employee,BindingResult bindingResult)
    {
        JsonUtil result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }

        if (employeeService.get(employee.getEmpId()) != null)
        {
            result =  JsonUtil.build(0,"员工已存在！",null);
        }
        else
            result = employeeService.insert(employee);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/update_all",method = RequestMethod.POST)
    private JsonUtil updateAll(@Valid Employee employee,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return employeeService.updateAll(employee);
    }
}
