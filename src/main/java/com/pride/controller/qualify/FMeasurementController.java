package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.vo.FinalMeasureCheckVO;
import com.pride.service.qualify.FinalMeasureCheckService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/measure")
public class FMeasurementController
{
    @Autowired
    private FinalMeasureCheckService finalMeasureCheckService;
    @RequestMapping("/find")
    public String find()
    {
        return "measurement_list";
    }
    @ResponseBody
    @RequestMapping("/list")
    public MyPageHelper<FinalMeasureCheckVO> getList(Integer page,Integer rows)
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
    }
}
