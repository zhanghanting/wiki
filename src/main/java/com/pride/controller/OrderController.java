package com.pride.controller;

import bean.MyPageHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Corder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.pride.service.CorderService;

import java.util.List;

@Controller
@RequestMapping("/erp/order/")
public class OrderController {

    @Autowired
    CorderService corderService;




    @ResponseBody
    @RequestMapping("find")
    public ModelAndView find(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_list");
        return modelAndView;
    }

    @RequestMapping("list")
    @ResponseBody
    public MyPageHelper query(){
        PageHelper.startPage(1, 10);
        List<Corder> corders = corderService.queryCorders();
        PageInfo<Corder> corderPageInfo = new PageInfo<>(corders);
        int endRow = corderPageInfo.getEndRow();
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows((List<Object>) corderPageInfo);
        myPageHelper.setTotal(endRow);
        return myPageHelper;
    }

}
