package com.pride.controller.technology;

import com.pride.domain.Technology;
import com.pride.domain.customize.EUDataGridResult;
import com.pride.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/17 19:57
 */

@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    @RequestMapping("/get/{technologyId}")
    public Technology getItemById(@PathVariable("technologyId") String technologyId){
        Technology technology = technologyService.get(technologyId);
        return technology;
    }

    @RequestMapping("/find")
    public String find(){
        return "technology_list";
    }

    @RequestMapping("/add")
    public String add(){
        return "technology_add";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "technology_edit";
    }


    public List<Technology> getData(){
        List<Technology> list = technologyService.find();
        return list;

    }




    //批量删除




    //根据工艺编号查找
    @RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public EUDataGridResult searchTechnologyByTechnologyId (Integer page, Integer rows, String searchValue){
        EUDataGridResult result = technologyService.searchTechnologyByTechnologyId(page, rows, searchValue);
        return result;
    }


    //根据工艺名称查找
    @RequestMapping("/search_technology_by_technologyName")
    @ResponseBody
    public EUDataGridResult searchTechnologyByTechnologyName (Integer page, Integer rows, String searchValue){
        EUDataGridResult result = technologyService.searchTechnologyByTechnologyName(page, rows, searchValue);
        return result;
    }




}
