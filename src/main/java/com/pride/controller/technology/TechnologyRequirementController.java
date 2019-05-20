package com.pride.controller.technology;


import com.pride.domain.Technology;
import com.pride.domain.TechnologyRequirement;
import com.pride.domain.vo.TechnologyRequirementVO;
import com.pride.service.technology.TechnologyRequirementService;
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
 * @Date: 2019/5/19 10:53
 */

@Controller
@RequestMapping("/erp/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    private TechnologyRequirementService technologyRequirementService;

    @RequestMapping("/get/{technologyRequirementId}")
    @ResponseBody
    public TechnologyRequirement getItemById(@PathVariable String technologyRequirementId)
            throws Exception{
        TechnologyRequirement technologyRequirement = technologyRequirementService.get(technologyRequirementId);
        return technologyRequirement;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getData() throws Exception{
        List<Technology> list = technologyRequirementService.find();
        return list;
    }

    //返回technologyRequirement_list页面
    @RequestMapping("/find")
    public String find(){
        return "technologyRequirement_list";
    }

    //返回分页的TechnologyRequirement的list
    @RequestMapping("/list")
    @ResponseBody
    public MyPageHelper getItemList(Integer page, Integer rows, TechnologyRequirementVO technologyRequirementPO){
        MyPageHelper result = technologyRequirementService.getList(page,rows,technologyRequirementPO);
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
        return "technologyRequirement_add";
    }

    //新增数据
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    private JsonUtil insert(@Valid TechnologyRequirement technologyRequirement, BindingResult bindingResult){
        JsonUtil result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }

        if (technologyRequirementService.get(technologyRequirement.getTechnologyRequirementId()) != null){
            result =  JsonUtil.build(0,"该工艺要求编号已经存在，请更换工艺编号！",null);
        } else{
            result = technologyRequirementService.insert(technologyRequirement);
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
        return "technologyRequirement_edit";
    }

    @RequestMapping(value="/update_requirement")
    @ResponseBody
    private JsonUtil updateNote(@Valid TechnologyRequirement technologyRequirement, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        return technologyRequirementService.updateRequirement(technologyRequirement);
    }


    //返回空的json
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return null;
    }

    //删除数据
    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private JsonUtil deleteBatch(String[] ids) throws Exception {
        JsonUtil result = technologyRequirementService.deleteBatch(ids);
        return result;
    }


    //更新数据
    @RequestMapping(value="/update_all")
    @ResponseBody
    private JsonUtil updateAll(@Valid TechnologyRequirement technologyRequirement, BindingResult bindingResult)
            throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        return technologyRequirementService.updateAll(technologyRequirement);
    }

    //根据工艺要求id查找
    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public MyPageHelper searchTechnologyRequirementByTechnologyRequirementId(Integer page, Integer rows, String searchValue) throws Exception{
        MyPageHelper result = technologyRequirementService.searchTechnologyRequirementByTechnologyRequirementId(page, rows, searchValue);
        return result;
    }

    //根据工艺名称查找
    @RequestMapping("/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public MyPageHelper searchTechnologyRequirementByTechnologyName(Integer page, Integer rows, String searchValue) throws Exception{
        MyPageHelper result = technologyRequirementService.searchTechnologyRequirementByTechnologyName(page, rows, searchValue);
        return result;
    }
}
