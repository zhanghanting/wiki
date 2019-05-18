package com.pride.controller.order;

import com.pride.domain.order.OrderPageType;
import com.pride.domain.typecode.TypeCode;
import com.pride.utils.MyPageHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Corder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pride.service.order.CorderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/erp/order/")
public class OrderController {

    @Autowired
    CorderService corderService;



    // 返回order_list页面
    @RequestMapping("find")
    public String find() {
        return "order_list";
    }
    // 返回分页的OrderPageType的List
    // json
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<OrderPageType> list(Integer page, Integer rows) {
        return corderService.viewAllOrders(page,rows);
    }


    // 跳转到order编辑页面
    @RequestMapping("edit")
    public String edit(){
        return "order_edit";
    }
    // 返回空的json
    @ResponseBody
    @RequestMapping("edit_judge")
    public String editJudge() {
        return null;
    }
    // 通过Corder对象更新订单
    // 返回json状态码
    @ResponseBody
    @RequestMapping("update_all")
    public TypeCode updateAll(Corder corder){
        return corderService.updateCorderByModel(corder);
    }


    // 返回order_add页面
    @RequestMapping("add")
    public String add(){
        return "order_add";
    }
    // 返回空的json
    @ResponseBody
    @RequestMapping("add_judge")
    public String addJudge(){
        return null;
    }
    // 新增一个Corder的实例
    // 返回json状态码
    @ResponseBody
    @RequestMapping("insert")
    public TypeCode insert(Corder corder){
        return corderService.insertOrder(corder);
    }



    // 删除请求
    @ResponseBody
    @RequestMapping("delete_judge")
    public String deleteJudge(){
        return null;
    }
    // 通过一个Sring的id数组删除订单Corder
    @ResponseBody
    @RequestMapping("delete_batch")
    public TypeCode deleteBatch(String[] ids){
        return corderService.deleteCordersByIds(ids);
    }

}