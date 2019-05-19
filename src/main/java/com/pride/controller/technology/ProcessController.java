package com.pride.controller.technology;


import com.pride.domain.Process;
import com.pride.service.technology.ProcessService;
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
@RequestMapping("/erp/process")
public class ProcessController {


    @Autowired
    private ProcessService processService;

    @RequestMapping("/get/{processId}")
    @ResponseBody
    public Process getItemById(@PathVariable String processId) throws Exception{
        Process process = processService.get(processId);
        return process;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Process> getData() throws Exception{
        List<Process> list = processService.find();
        return list;
    }

    //返回process_list页面
    @RequestMapping("/find")
    public String find() throws Exception{
        return "process_list";
    }

    //返回分页的Process的list
    @RequestMapping("/list")
    @ResponseBody
    public MyPageHelper getItemList(Integer page, Integer rows, Process process) throws Exception{
        MyPageHelper result = processService.getList(page, rows, process);
        return result;
    }

    //返回空的json
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "null";
    }

    //返回process_add页面
    @RequestMapping("/add")
    public String add() throws Exception{
        return "process_add";
    }

    //新增数据
    @RequestMapping(value="/insert", method=RequestMethod.POST)
    @ResponseBody
    private JsonUtil insert(@Valid Process process, BindingResult bindingResult) throws Exception {
        JsonUtil result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        if(processService.get(process.getProcessId()) != null){
            result = new JsonUtil(0, "该工序编号已经存在，请更换工序编号！", null);
        }else{
            result = processService.insert(process);
        }
        return result;
    }


    //返回空的json
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return null;
    }

    //返回process_edit页面
    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "process_edit";
    }

    //更新数据
    @RequestMapping(value="/update_all")
    @ResponseBody
    private JsonUtil updateAll(@Valid Process process, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100, fieldError.getDefaultMessage());
        }
        return processService.updateAll(process);
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
        JsonUtil result = processService.deleteBatch(ids);
        return result;
    }

    //根据工序id查找
    @RequestMapping("/search_process_by_processId")
    @ResponseBody
    public MyPageHelper searchProcessByProcessId(Integer page, Integer rows, String searchValue) throws Exception{
        MyPageHelper result = processService.searchProcessByProcessId(page, rows, searchValue);
        return result;
    }

    //根据工序计划id查找
    @RequestMapping("/search_process_by_technologyPlanId")
    @ResponseBody
    public MyPageHelper searchProcessByTechnologyPlanId(Integer page, Integer rows, String searchValue)
            throws Exception{
        MyPageHelper result = processService.searchProcessByTechnologyPlanId(page, rows, searchValue);
        return result;
    }

}
