package com.pride.controller.custom;


import com.pride.domain.Custom;
import com.pride.domain.typecode.TypeCode;
import com.pride.service.custom.CustomService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/custom/")
public class CustomController {

    @Autowired
    CustomService customService;


    // 跳转到custom的主页面
    @RequestMapping("find")
    public String find(){
        return "custom_list";
    }
    // 返回分页的Custom的List
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<Custom> list(Integer page,Integer rows){
        return customService.viewPageCustoms(page,rows);
    }


    //通过id查询custom
    @ResponseBody
    @RequestMapping("get/{id}")
    public Custom getCustom(@PathVariable String id){
        return customService.selectCustomById(id);
    }
    // 通过customId模糊查询
    @ResponseBody
    @RequestMapping("search_custom_by_customId")
    public MyPageHelper<Custom> searchCustomByCustomId(String searchValue,Integer page,Integer rows){
        return customService.searchCustomByCustomId(searchValue,page,rows);
    }
    // 通过customName模糊查询
    @ResponseBody
    @RequestMapping("search_custom_by_customName")
    public MyPageHelper<Custom> searchCustomByCustomName(String searchValue,Integer page,Integer rows){
        return customService.searchCustomByCustomName(searchValue,page,rows);
    }



    //返回所有的Custom
    @ResponseBody
    @RequestMapping("get_data")
    public List<Custom> getData(){
        return customService.viewAllCustoms();
    }


    // 返回custom的添加页面
    @RequestMapping("add")
    public String add(){
        return "custom_add";
    }
    // 返回空的json数据
    @ResponseBody
    @RequestMapping("add_judge")
    public String addJudge(){
        return null;
    }
    // 通过custom的实例新增数据
    // 返回json的状态码
    @ResponseBody
    @RequestMapping("insert")
    public TypeCode insert(Custom custom){
        return customService.insertCustom(custom);
    }


    // 加载删除页面
    // 返回空的json
    @ResponseBody
    @RequestMapping("delete_judge")
    public String deleteJudge(){
        return null;
    }
    // 通过id的数组删除custom
    // 返回json的状态码
    @ResponseBody
    @RequestMapping("delete_batch")
    public TypeCode delete(String[] ids){
        return customService.deleteCustomsByIds(ids);
    }


}
