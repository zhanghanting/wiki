package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.FinalMeasuretCheck;
import com.pride.domain.UnqualifyApply;
import com.pride.domain.vo.FinalMeasureCheckVO;
import com.pride.service.qualify.FinalMeasureCheckService;
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
public class FMeasurementController
{
    @Autowired
    private FinalMeasureCheckService finalMeasureCheckService;
    @RequestMapping("/measure/find")
    public String find()
    {
        return "measurement_list";
    }
    @ResponseBody
    @RequestMapping("/measure/list")
    private MyPageHelper getList(int page,int rows)
    {
        return finalMeasureCheckService.getList(page,rows);
    }
   /* public MyPageHelper<FinalMeasureCheckVO> getList(Integer page,Integer rows)
    {
        PageHelper.startPage(page,rows);
        //获取成品的所有信息
        List<FinalMeasureCheckVO> finalMeasureCheckVOS = finalMeasureCheckService.queryFinalMeasureCheckVO();
        //将获取的信息封装为page
        PageInfo<FinalMeasureCheckVO> finalMeasureCheckPageInfo = new PageInfo<>(finalMeasureCheckVOS );
        MyPageHelper MyPageHelper = new MyPageHelper();
        MyPageHelper.setRows(finalMeasureCheckVOS);
        MyPageHelper.setTotal(finalMeasureCheckPageInfo.getTotal());
        return MyPageHelper;
    }*/
    @ResponseBody
    @RequestMapping("fMeasureCheck/add_judge")
    public Map<String,String> add_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("fMeasureCheck/edit_judge")
    public Map<String,String> edit_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("fMeasureCheck/delete_judge")
    public Map<String,String> delete_judge()
    {
        Map<String,String> map = new HashMap<>();
        map.put("msg",null);
        return map;
    }

    @RequestMapping("measure/add")
    public String add()
    {
        return "measurement_add";
    }
    @RequestMapping("measure/edit")
    public String edit()
    {
        return "measurement_edit";
    }
    /**
     * insert一条成品计量检测记录
     */
    @ResponseBody
    @RequestMapping(value = "measure/insert",method = RequestMethod.POST)
    private JsonUtil insert(@Valid FinalMeasuretCheck finalMeasuretCheck,BindingResult bindingResult)
    {
        JsonUtil result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }

        if (finalMeasureCheckService.get(finalMeasuretCheck.getfMeasureCheckId()) != null)
        {
            result =  JsonUtil.build(0,"该成品计量质检编号已经存在，请更换成品计量质检编号！",null);
        }
        else
            result = finalMeasureCheckService.insert(finalMeasuretCheck);
        return result;
    }
   @ResponseBody
    @RequestMapping(value = "/measure/update_all",method = RequestMethod.POST)
    private JsonUtil updateAll(@Valid FinalMeasuretCheck finalMeasuretCheck,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return finalMeasureCheckService.updateAll(finalMeasuretCheck);
    }
    @ResponseBody
    @RequestMapping(value = "/measure/delete_batch")
    private JsonUtil deleteBatch(String[] ids)
    {
        return finalMeasureCheckService.deleteBatch(ids);
    }
    //通过成品计量质检编号查询
    @ResponseBody
    @RequestMapping(value = "/measure/search_fMeasureCheck_by_fMeasureCheckId")
    private MyPageHelper searchFMeasureCheckByfMeasureCheckId(int page,int rows,String searchValue)
    {
        return finalMeasureCheckService.searchFMeasureCheckByfMeasureCheckId(page,rows,searchValue);
    }
    //通过订单编号查询
    @ResponseBody
    @RequestMapping("/measure/search_fMeasureCheck_by_orderId")
    private MyPageHelper searchFMeasureCheckByOrderId(int page,int rows,String searchValue)
    {
        return finalMeasureCheckService.searchFMeasureCheckByOrderId(page,rows,searchValue);
    }

    @ResponseBody
    @RequestMapping(value = "/measure/update_note")
    private JsonUtil updateNote(@Valid FinalMeasuretCheck finalMeasuretCheck,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            FieldError fieldError = bindingResult.getFieldError();
            return JsonUtil.build(100,fieldError.getDefaultMessage());
        }
        else
            return finalMeasureCheckService.updateNote(finalMeasuretCheck);
    }

}
