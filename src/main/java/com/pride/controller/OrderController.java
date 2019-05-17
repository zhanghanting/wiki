package com.pride.controller;

import com.pride.domain.Corder;
import com.pride.service.CorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public List<Corder> query(){
        return corderService.queryCorders();
    }

}
