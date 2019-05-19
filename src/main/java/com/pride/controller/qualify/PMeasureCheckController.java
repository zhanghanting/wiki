package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.vo.ProcessMeasureCheckVO;
import com.pride.service.qualify.ProcessMeasureCheckService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/p_measure_check")
public class PMeasureCheckController
{
    @Autowired
    private ProcessMeasureCheckService processMeasureCheckService;
    @RequestMapping("/find")
    public String find()
    {
        return "p_measure_check_list";
    }
    @ResponseBody
    @RequestMapping("/list")
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
}
