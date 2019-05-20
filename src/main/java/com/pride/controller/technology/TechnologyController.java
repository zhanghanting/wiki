package com.pride.controller.technology;

import com.pride.domain.Technology;
import com.pride.service.technology.TechnologyService;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
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

    //返回technology_list页面
    @RequestMapping("/find")
    public String find(){
        return "technology_list";
    }

    //返回分页的Technology的list
    @RequestMapping("/list")
    @ResponseBody
    public MyPageHelper getItemList(Integer page, Integer rows, Technology technology){
        MyPageHelper result = technologyService.getList(page,rows,technology);
        return result;
    }


    //返回空的json
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "null";
    }

    //返回technology_add页面
    @RequestMapping("/add")
    public String add(){
        return "technology_add";
    }

    //新增数据
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


    //返回空的json
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return null;
    }

    //返回technology_edit页面
    @RequestMapping("/edit")
    public String edit(){
        return "technology_edit";
    }

    //更新数据
    @RequestMapping(value = "/update_all")
    @ResponseBody
    private JsonUtil updateAll(@Valid Technology technology, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        return technologyService.updateAll(technology);
    }


    //返回空的json
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return null;
    }

    //删除数据
    @RequestMapping(value = "/delete_batch")
    @ResponseBody
    private JsonUtil deleteBatch(String[] ids){
        JsonUtil result = technologyService.deleteBatch(ids);
        return result;
    }


    @RequestMapping("/get/{technologyId}")
    @ResponseBody
    public Technology getItemById(@PathVariable("technologyId") String technologyId){
        Technology technology = technologyService.get(technologyId);
        return technology;
    }


    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getData(){
        List<Technology> list = technologyService.find();
        return list;
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
