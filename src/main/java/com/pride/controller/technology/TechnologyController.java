package com.pride.controller.technology;

import com.pride.domain.Technology;
import com.pride.service.TechnologyService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/17 19:57
 */

@Controller
@RequestMapping("/erp/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @RequestMapping("/get/{technologyId}")
    @ResponseBody
    public Technology getItemById(@PathVariable("technologyId") String technologyId){
        Technology technology = technologyService.get(technologyId);
        return technology;
    }

    @RequestMapping("/find")
    public String find(){
        return "technology_list";
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String add(){
        return "technology_add";
    }

    @RequestMapping("/add")
    public String add1(){
        return "technology_add";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit(){
        return null;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete(){
        return null;
    }

    @RequestMapping("/edit")
    public String edit1(){
        return "technology_edit";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getData(){
        List<Technology> list = technologyService.find();
        return list;
    }

    @RequestMapping("/list")
    @ResponseBody
    public MyPageHelper getItemList(Integer page, Integer rows, Technology technology){
        MyPageHelper result = technologyService.getList(page,rows,technology);
        return result;
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    private JsonUtil insert(@Valid Technology technology, BindingResult bindingResult){
        JsonUtil result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }

        if (technologyService.get(technology.getTechnologyId()) != null){
            result =  JsonUtil.build(0,"该工艺编号已经存在，请更换工艺编号！",null);
        } else{
            result = technologyService.insert(technology);
        }
        return result;
    }

    @RequestMapping(value = "/update_all")
    @ResponseBody
    private JsonUtil updateAll(@Valid Technology technology, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        return technologyService.updateAll(technology);
    }



    //批量删除
    @RequestMapping(value = "/delete_batch")
    @ResponseBody
    private JsonUtil deleteBatch(String[] ids){
        JsonUtil result = technologyService.deleteBatch(ids);
        return result;
    }



    //根据工艺编号查找
    @RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public MyPageHelper searchTechnologyByTechnologyId (Integer page, Integer rows, String searchValue){
        MyPageHelper result = technologyService.searchTechnologyByTechnologyId(page, rows, searchValue);
        return result;
    }

    //根据工艺名称查找
    @RequestMapping("/search_technology_by_technologyName")
    @ResponseBody
    public MyPageHelper searchTechnologyByTechnologyName (Integer page, Integer rows, String searchValue){
        MyPageHelper result = technologyService.searchTechnologyByTechnologyName(page, rows, searchValue);
        return result;
    }
}
