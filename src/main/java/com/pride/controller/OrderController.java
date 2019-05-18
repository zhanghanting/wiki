package com.pride.controller;
import com.pride.bean.MyPageHelper;
import com.pride.bean.MyPageHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Corder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.pride.service.CorderService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@Controller
@RequestMapping("/erp/order/")
public class OrderController {

    @Autowired
    CorderService corderService;

    @ResponseBody
    @RequestMapping("find")
    public ModelAndView find(HttpServletRequest request, HttpServletResponse response,PrintWriter out) throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_list");
        out.println(query());
        return modelAndView;
    }

    @RequestMapping("list")
    @ResponseBody
    public MyPageHelper<Corder> query(){
        PageHelper.startPage(1, 10);
        List<Corder> corders = corderService.queryCorders();
        PageInfo<Corder> corderPageInfo = new PageInfo<>(corders);
        int endRow = corderPageInfo.getEndRow();
        List<Corder> list = corderPageInfo.getList();
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(list);
        myPageHelper.setTotal(endRow);
        return myPageHelper;
    }

}
