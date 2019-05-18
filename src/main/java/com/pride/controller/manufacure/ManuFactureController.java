package com.pride.controller.manufacure;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.manufacture.ManufacturePageType;
import com.pride.service.manufacture.ManuFactureService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/manufacture/")
public class ManuFactureController {

    @Autowired
    ManuFactureService manuFactureService;

    // 跳转到主页面manufacture主页面
    @RequestMapping("find")
    public String find(){
        return "manufacture_list";
    }
    // 返回分页的ManufacturePageType的List
    // json
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<ManufacturePageType> list(Integer page,Integer rows){
        return manuFactureService.viewPageManufacturePageType(page,rows);
    }
}
