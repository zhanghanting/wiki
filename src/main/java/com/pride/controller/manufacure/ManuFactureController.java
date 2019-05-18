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

    @RequestMapping("find")
    public String find(){
        return "manufacture_list";
    }

    // 返回分页的ManufacturePageType的List
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<ManufacturePageType> list(Integer page,Integer rows){
        PageHelper.startPage(page,rows);
        List<ManufacturePageType> manufacturePageTypes = manuFactureService.viewAllManufacturePageType();
        PageInfo<ManufacturePageType> pageInfo = new PageInfo<>(manufacturePageTypes);
        MyPageHelper<ManufacturePageType> pageHelper = new MyPageHelper<>();
        pageHelper.setRows(manufacturePageTypes);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }
}
