package com.pride.controller.order;

import com.pride.domain.order.OrderPageType;
import com.pride.utils.MyPageHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Corder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pride.service.order.CorderService;

import java.util.List;

@Controller
@RequestMapping("/erp/order/")
public class OrderController {

    @Autowired
    CorderService corderService;


    @RequestMapping("find")
    public String find() {
        return "order_list";
    }

    // 返回分页的OrderPageType的List
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<OrderPageType> query(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<OrderPageType> corders = corderService.viewAllOrders();
        PageInfo<OrderPageType> pageInfo = new PageInfo<>(corders);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setRows(corders);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }

}