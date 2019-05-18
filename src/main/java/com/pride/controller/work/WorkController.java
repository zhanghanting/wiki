package com.pride.controller.work;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.pride.domain.work.WorkPageType;
import com.pride.service.wrok.WorkService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/work/")
public class WorkController {

    @Autowired
    WorkService workService;

    @RequestMapping("find")
    public String find(){
        return "work_list";
    }

    // 返回分页的WorkPageType的List
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<WorkPageType> list(Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        List<WorkPageType> workPageTypes = workService.viewAllWorks();
        PageInfo<WorkPageType> pageInfo = new PageInfo<>(workPageTypes);
        MyPageHelper<WorkPageType> pageHelper = new MyPageHelper<>();
        pageHelper.setTotal(pageInfo.getTotal());
        pageHelper.setRows(workPageTypes);
        return pageHelper;
    }
}
