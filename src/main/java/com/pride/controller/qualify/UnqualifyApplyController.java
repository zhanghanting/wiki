package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Corder;
import com.pride.domain.Technology;
import com.pride.domain.UnqualifyApply;
import com.pride.domain.vo.UnqualifyApplyVO;
import com.pride.service.qualify.UnqualifyService;
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
@RequestMapping("/erp/unqualify")
public class UnqualifyApplyController
{
    @Autowired
    private UnqualifyService unqualifyService;
    @RequestMapping("/find")
    public String find()
    {
        return "unqualify_list";
    }
    @ResponseBody
    @RequestMapping("/list")
    public MyPageHelper<UnqualifyApplyVO> getList(Integer page,Integer rows)
    {
        PageHelper.startPage(page,rows);
        //获取不合格品的所有管理信息
        List<UnqualifyApplyVO> unqualifyApplyVOList = unqualifyService.queryUnqualifyApplyVOList();
        //将获取的信息封装为page
        PageInfo<UnqualifyApplyVO> unqualifyApplyVOPageInfo = new PageInfo<>(unqualifyApplyVOList);
        MyPageHelper MyPageHelper = new MyPageHelper();
        MyPageHelper.setRows(unqualifyApplyVOList);
        MyPageHelper.setTotal(unqualifyApplyVOPageInfo.getTotal());
        return MyPageHelper;
    }
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String,String> add_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String,String> edit_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String,String> delete_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }

    @RequestMapping("/add")
    public String add()
    {
        return "unqualify_add";
    }
    @RequestMapping("/edit")
    public String edit()
    {
        return "unqualify_edit";
    }
    /**
     * insert一条UnqualifyApply记录
     */
    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    private JsonUtil insert(@Valid UnqualifyApply unqualifyApply,BindingResult bindingResult)
    {
        JsonUtil result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }

        if (unqualifyService.get(unqualifyApply.getUnqualifyApplyId()) != null)
        {
            result =  JsonUtil.build(0,"该不合格品编号已经存在，请更换不合格品编号！",null);
        }
        else
             result = unqualifyService.insert(unqualifyApply);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/update_all",method = RequestMethod.POST)
    private JsonUtil updateAll(@Valid UnqualifyApply unqualifyApply,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return unqualifyService.updateAll(unqualifyApply);
    }
    @ResponseBody
    @RequestMapping(value = "/update_note")
    private JsonUtil updateNote(@Valid UnqualifyApply unqualifyApply,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return unqualifyService.updateNote(unqualifyApply);
    }
    @ResponseBody
    @RequestMapping(value = "/delete_batch")
    private JsonUtil deleteBatch(String[] ids)
    {
       return unqualifyService.deleteBatch(ids);
    }
    @ResponseBody
    @RequestMapping(value = "/search_unqualify_by_unqualifyId")
    private MyPageHelper serarchUnqualifyByUnqualifyId(int page,int rows,String searchValue)
    {
        return unqualifyService.searchUnqualifyByUnqualifyId(page,rows,searchValue);
    }

    @ResponseBody
    @RequestMapping("/search_unqualify_by_productName")
    private MyPageHelper searchUnqualifyByProductName(int page,int rows,String searchValue)
    {
        return unqualifyService.serarchUnqualifyByProductName(page,rows,searchValue);
    }

}
