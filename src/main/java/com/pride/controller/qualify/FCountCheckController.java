package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.FinalCountCheck;
import com.pride.domain.UnqualifyApply;
import com.pride.domain.vo.FinalCountCheckVO;
import com.pride.service.qualify.FinalCountCheckService;
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
public class FCountCheckController
{
    @Autowired
    private FinalCountCheckService finalCountCheckService;
    @RequestMapping("/f_count_check/find")
    public String find()
    {
        return "f_count_check_list";
    }
    @ResponseBody
    @RequestMapping("/f_count_check/list")
    public MyPageHelper<FinalCountCheckVO> getList(Integer page,Integer rows)
    {
        PageHelper.startPage(page,rows);
        //获取所有成品计数信息
        List<FinalCountCheckVO> finalCountCheckVOS = finalCountCheckService.queryFinalCountCheckVO();
        //将获取的信息封装为page
        PageInfo<FinalCountCheckVO> finalCountCheckVOPageInfo = new PageInfo<>(finalCountCheckVOS);
        MyPageHelper MyPageHelper = new MyPageHelper();
        MyPageHelper.setRows(finalCountCheckVOS);
        MyPageHelper.setTotal(finalCountCheckVOPageInfo.getTotal());
        return MyPageHelper;
    }
    @ResponseBody
    @RequestMapping("/fCountCheck/add_judge")
    public Map<String,String> add_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/fCountCheck/edit_judge")
    public Map<String,String> edit_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/fCountCheck/delete_judge")
    public Map<String,String> delete_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }

    @RequestMapping("/f_count_check/add")
    public String add() throws Exception
    {
        return "f_count_check_add";
    }

    @RequestMapping("/f_count_check/edit")
    public String edit() throws Exception
    {
        return "f_count_check_edit";
    }
    @ResponseBody
    @RequestMapping(value = "/f_count_check/insert",method = RequestMethod.POST)
    private JsonUtil insert(@Valid FinalCountCheck finalCountCheck,BindingResult bindingResult)
    {
        JsonUtil result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }

        if (finalCountCheckService.get(finalCountCheck.getfCountCheckId()) != null)
        {
            result =  JsonUtil.build(0,"该成品计数编号已经存在，请更换成品计数编号！",null);
        }
        else
            result = finalCountCheckService.insert(finalCountCheck);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/f_count_check/update_all",method = RequestMethod.POST)
    private JsonUtil updateAll(@Valid FinalCountCheck finalCountCheck,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return finalCountCheckService.updateAll(finalCountCheck);
    }
    @ResponseBody
    @RequestMapping(value = "/f_count_check/update_note")
    private JsonUtil updateNote(@Valid FinalCountCheck finalCountCheck,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return finalCountCheckService.updateNote(finalCountCheck);
    }
    @ResponseBody
    @RequestMapping(value = "/f_count_check/delete_batch")
    private JsonUtil deleteBatch(String[] ids)
    {
        return finalCountCheckService.deleteBatch(ids);
    }
    @ResponseBody
    @RequestMapping(value = "/f_count_check/search_fCountCheck_by_fCountCheckId")
    private MyPageHelper searchFCountCheckByFCountCheckId(int page,int rows,String searchValue)
    {
        return finalCountCheckService.searchFCountCheckByFCountCheckId(page,rows,searchValue);
    }

    @ResponseBody
    @RequestMapping("/f_count_check/search_fCountCheck_by_orderId")
    private MyPageHelper search_fCountCheck_by_orderId(int page,int rows,String searchValue)
    {
        return finalCountCheckService.searchFCountCheckByOrderId(page,rows,searchValue);
    }
}
