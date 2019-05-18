package com.pride.controller.custom;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Custom;
import com.pride.service.custom.CustomService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/custom/")
public class CustomController {

    @Autowired
    CustomService customService;

    @RequestMapping("find")
    public String find(){
        return "custom_list";
    }

    // 返回分页的Custom的List
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<Custom> list(Integer page,Integer rows){
        PageHelper.startPage(page,rows);
        List<Custom> customs =customService.viewAllCustoms();
        PageInfo<Custom> PageInfo = new PageInfo<>(customs);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setRows(customs);
        pageHelper.setTotal(PageInfo.getTotal());
        return pageHelper;
    }


}
