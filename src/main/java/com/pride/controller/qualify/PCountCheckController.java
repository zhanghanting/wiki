package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.ProcessCountCheck;
import com.pride.domain.vo.ProcessCountCheckVO;
import com.pride.service.qualify.ProcessCountCheckService;
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
public class PCountCheckController
{
    @Autowired
    ProcessCountCheckService processCountCheckService;
    @RequestMapping("/p_count_check/find")
    public String find()
    {
        return "p_count_check_list";
    }
    @ResponseBody
    @RequestMapping("/p_count_check/list")
    public MyPageHelper<ProcessCountCheckVO> getList(Integer page,Integer rows)
    {
        PageHelper.startPage(page,rows);
        //获取工序计数的所有信息
        List<ProcessCountCheckVO> processCountCheckVOS = processCountCheckService.queryProcessCountCheckVO();
        //将获取的信息封装为page
        PageInfo<ProcessCountCheckVO> processCountCheckVOPageInfo = new PageInfo<>(processCountCheckVOS);
        MyPageHelper MyPageHelper = new MyPageHelper();
        MyPageHelper.setRows(processCountCheckVOS);
        MyPageHelper.setTotal(processCountCheckVOPageInfo.getTotal());
        return MyPageHelper;
    }
    @ResponseBody
    @RequestMapping("/pCountCheck/add_judge")
    public Map<String,String> add_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/pCountCheck/edit_judge")
    public Map<String,String> edit_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/pCountCheck/delete_judge")
    public Map<String,String> delete_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @RequestMapping("/p_count_check/add")
    public String add()
    {
        return "p_count_check_add";
    }
    @RequestMapping("/p_count_check/edit")
    public String edit()
    {
        return "p_count_check_edit";
    }
    /**
     * insert一条UnqualifyApply记录
     */
   @ResponseBody
    @RequestMapping(value = "/p_count_check/insert",method = RequestMethod.POST)
    private JsonUtil insert(@Valid ProcessCountCheck processCountCheck,BindingResult bindingResult)
    {
        JsonUtil result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }

        if (processCountCheckService.get(processCountCheck.getpCountCheckId()) != null)
        {
            result =  JsonUtil.build(0,"该不合格品编号已经存在，请更换不合格品编号！",null);
        }
        else
            result = processCountCheckService.insert(processCountCheck);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/p_count_check/update_all",method = RequestMethod.POST)
    private JsonUtil updateAll(@Valid ProcessCountCheck processCountCheck,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return processCountCheckService.updateAll(processCountCheck);
    }

    @ResponseBody
    @RequestMapping(value = "/p_count_check/update_note")
    private JsonUtil updateNote(@Valid ProcessCountCheck processCountCheck,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return processCountCheckService.updateNote(processCountCheck);
    }
    @ResponseBody
    @RequestMapping(value = "/p_count_check/delete_batch")
    private JsonUtil deleteBatch(String[] ids)
    {
        return processCountCheckService.deleteBatch(ids);
    }
    @ResponseBody
    @RequestMapping(value = "/p_count_check/search_pCountCheck_by_pCountCheckId")
    private MyPageHelper  searchpCountCheckBypCountCheckId(int page,int rows,String searchValue)
    {
        return processCountCheckService.searchpCountCheckBypCountCheckId(page,rows,searchValue);
    }

}
