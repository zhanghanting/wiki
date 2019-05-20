package com.pride.controller.technology;

import com.pride.domain.TechnologyPlan;
import com.pride.domain.vo.TechnologyPlanVO;
import com.pride.service.technology.TechnologyPlanService;
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
 * @Date: 2019/5/19 17:56
 */
@Controller
@RequestMapping("/erp/technologyPlan")
public class TechnologyPlanController {
    @Autowired
    private TechnologyPlanService technologyPlanService;

    @RequestMapping("/get/{technologyPlanId}")
    @ResponseBody
    public TechnologyPlan getItemById(@PathVariable String technologyPlanId) throws Exception{
        TechnologyPlan technologyPlan = technologyPlanService.get(technologyPlanId);
        return technologyPlan;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<TechnologyPlan> getData() throws Exception{
        List<TechnologyPlan> list = technologyPlanService.find();
        return list;
    }

    //返回technologyPlan_list页面
    @RequestMapping("/find")
    public String find() throws Exception{
        return "technologyPlan_list";
    }

    //返回分页的TechnologyPlanVO的list
    @RequestMapping("/list")
    @ResponseBody
    public MyPageHelper getItemList(Integer page, Integer rows, TechnologyPlanVO technologyPlanPO)
            throws Exception{
        MyPageHelper result = technologyPlanService.getList(page, rows, technologyPlanPO);
        return result;
    }

    //返回空的json
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "null";
    }

    //返回technologyPlan_add页面
    @RequestMapping("/add")
    public String add() {
        return "technologyPlan_add";
    }

    //新增数据
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private JsonUtil insert(@Valid TechnologyPlan technologyPlan, BindingResult bindingResult) throws Exception {
        JsonUtil result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        if(technologyPlanService.get(technologyPlan.getTechnologyPlanId()) != null){
            result = new JsonUtil(0, "该工艺计划编号已经存在，请更换工艺计划编号！", null);
        }else{
            result = technologyPlanService.insert(technologyPlan);
        }
        return result;
    }


    //返回空的json
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return null;
    }

    //返回technologyPlan_edit页面
    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "technologyPlan_edit";
    }

    //更新数据
    @RequestMapping(value="/update_all")
    @ResponseBody
    private JsonUtil updateAll(@Valid TechnologyPlan technologyPlan, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        return technologyPlanService.updateAll(technologyPlan);
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
        JsonUtil result = technologyPlanService.deleteBatch(ids);
        return result;
    }

    //根据工艺计划id查找
    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public MyPageHelper searchTechnologyPlanByTechnologyPlanId(Integer page, Integer rows, String searchValue)
            throws Exception{
        MyPageHelper result = technologyPlanService.searchTechnologyPlanByTechnologyPlanId(page, rows, searchValue);
        return result;
    }

    //根据工艺名称查找
    @RequestMapping("/search_technologyPlan_by_technologyName")
    @ResponseBody
    public MyPageHelper searchTechnologyPlanByTechnologyName(Integer page, Integer rows, String searchValue)
            throws Exception{
        MyPageHelper result = technologyPlanService.searchTechnologyPlanByTechnologyName(page, rows, searchValue);
        return result;
    }
}
