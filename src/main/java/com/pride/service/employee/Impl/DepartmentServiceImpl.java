package com.pride.service.employee.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Department;
import com.pride.domain.DepartmentExample;
import com.pride.domain.vo.EmployeeVO;
import com.pride.mapper.DepartmentMapper;
import com.pride.service.employee.DepartmentService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> getData()
    {
        List<Department> departments = departmentMapper.selectByExample(new DepartmentExample());
        return departments;
    }

    @Override
    public Department get(String departmentId)
    {
        Department department = departmentMapper.selectByPrimaryKey(departmentId);
        return department;
    }

    @Override
    public JsonUtil insert(Department department)
    {
        int insert = departmentMapper.insert(department);
        if(insert > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"添加部门信息失败");
    }

    @Override
    public JsonUtil updateAll(Department department)
    {
        int update = departmentMapper.updateByPrimaryKey(department);
        if(update > 0)
            return JsonUtil.ok();
        else
            return JsonUtil.build(101,"更新失败");
    }

    @Override
    public MyPageHelper getList(int page,int rows)
    {
        PageHelper.startPage(page,rows);
        List<Department> departments = getData();
        PageInfo<Department> departmentPageInfo = new PageInfo<>(departments);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(departments);
        myPageHelper.setTotal( departmentPageInfo .getTotal());
        return myPageHelper;
    }
}
