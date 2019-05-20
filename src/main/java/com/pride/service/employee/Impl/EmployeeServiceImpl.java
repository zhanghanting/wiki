package com.pride.service.employee.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Employee;
import com.pride.domain.EmployeeExample;
import com.pride.domain.vo.EmployeeVO;
import com.pride.domain.vo.UnqualifyApplyVO;
import com.pride.mapper.EmployeeMapper;
import com.pride.service.employee.EmployeeService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
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
    public List<EmployeeVO> getList()
    {
        List<EmployeeVO> employeeVOS = employeeMapper.find();
        return employeeVOS;
    }

    @Override
    public Employee get(String empId)
    {
        return employeeMapper.selectByPrimaryKey(empId);
    }

    @Override
    public JsonUtil insert(Employee employee)
    {
        int insert = employeeMapper.insert(employee);
        if(insert > 0)
        {
            //插入成功
            return JsonUtil.ok();
        }
        else
        {
            return JsonUtil.build(101,"增加员工信息失败");
        }
    }

    @Override
    public JsonUtil updateAll(Employee employee)
    {
        int update = employeeMapper.updateByPrimaryKey(employee);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"修改当前员工失败");
    }

    /**
     * 返回所有employeeVO的分页
     * @param page
     * @param rows
     * @return
     */
    @Override
    public MyPageHelper getList(int page,int rows)
    {
        PageHelper.startPage(page,rows);
        List<EmployeeVO> employeeVOS = getList();
        PageInfo<EmployeeVO> employeesPageInfo = new PageInfo<>(employeeVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(employeeVOS);
        myPageHelper.setTotal( employeesPageInfo .getTotal());
        return myPageHelper;
    }

    @Override
    public EmployeeVO getVO(String emId)
    {
        EmployeeVO employeeVO = employeeMapper.selectEmployeeVO(emId);
        return employeeVO;
    }
}
