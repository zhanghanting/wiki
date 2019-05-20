package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.ProcessMeasureCheck;
import com.pride.domain.UnqualifyApply;
import com.pride.domain.vo.ProcessMeasureCheckVO;
import com.pride.service.qualify.ProcessMeasureCheckService;
import com.pride.utils.JsonUtil;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/erp")
public class PMeasureCheckController
{
    @Autowired
    private ProcessMeasureCheckService processMeasureCheckService;
    @RequestMapping("/p_measure_check/find")
    public String find()
    {
        return "p_measure_check_list";
    }
    @ResponseBody
    @RequestMapping("/p_measure_check/list")
    public MyPageHelper<ProcessMeasureCheckVO> getList(Integer page,Integer rows)
    {
        PageHelper.startPage(page,rows);
        //获取所有工序计量质检信息
        List<ProcessMeasureCheckVO> processMeasureCheckVOS = processMeasureCheckService.queryProcessMeasureCheckVO();
        //将获取的信息封装为page
        PageInfo<ProcessMeasureCheckVO> processMeasureCheckVOPageInfo = new PageInfo<>(processMeasureCheckVOS);
        MyPageHelper MyPageHelper = new MyPageHelper();
        MyPageHelper.setRows(processMeasureCheckVOS);
        MyPageHelper.setTotal(processMeasureCheckVOPageInfo.getTotal());
        return MyPageHelper;
    }
    @ResponseBody
    @RequestMapping("/pMeasureCheck/add_judge")
    public Map<String,String> add_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/pMeasureCheck/edit_judge")
    public Map<String,String> edit_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/pMeasureCheck/delete_judge")
    public Map<String,String> delete_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @RequestMapping("/p_measure_check/add")
    public String add()
    {
        return "p_measure_check_add";
    }
    @RequestMapping("/p_measure_check/edit")
    public String edit()
    {
        return "p_measure_check_edit";
    }
    /**
     * insert一条UnqualifyApply记录
     */
    @ResponseBody
    @RequestMapping(value = "/p_measure_check/insert",method = RequestMethod.POST)
    private JsonUtil insert(@Valid ProcessMeasureCheck processMeasureCheck,BindingResult bindingResult)
    {
        JsonUtil result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }

        if (processMeasureCheckService.get(processMeasureCheck.getpMeasureCheckId()) != null)
        {
            result =  JsonUtil.build(0,"该不合格品编号已经存在，请更换不合格品编号！",null);
        }
        else
            result = processMeasureCheckService.insert(processMeasureCheck);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/p_measure_check/update_all",method = RequestMethod.POST)
    private JsonUtil updateAll(@Valid ProcessMeasureCheck processMeasureCheck,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return processMeasureCheckService.updateAll(processMeasureCheck);
    }

    @ResponseBody
    @RequestMapping(value = "/p_measure_check/update_note")
    private JsonUtil updateNote(@Valid ProcessMeasureCheck processMeasureCheck,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return processMeasureCheckService.updateNote(processMeasureCheck);
    }
    @ResponseBody
    @RequestMapping(value = "/p_measure_check/delete_batch")
    private JsonUtil deleteBatch(String[] ids)
    {
        return processMeasureCheckService.deleteBatch(ids);
    }
    @ResponseBody
    @RequestMapping(value = "/p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    private MyPageHelper searchPMeasureCheckByPMeasureCheckId(int page,int rows,String searchValue)
    {
        return processMeasureCheckService.searchPMeasureCheckByPMeasureCheckId(page,rows,searchValue);
    }

}
