package com.pride.controller.order;

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

    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<Corder> query(Integer page,Integer rows){
        PageHelper.startPage(page, rows);
        List<Corder> corders = corderService.queryCorders();
        PageInfo<Corder> corderPageInfo = new PageInfo<>(corders);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(corders);
        myPageHelper.setTotal(corderPageInfo.getTotal());
        return myPageHelper;
    }

}
