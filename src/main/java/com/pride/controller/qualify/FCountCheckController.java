package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.FinalCountCheck;
import com.pride.domain.vo.FinalCountCheckVO;
import com.pride.service.qualify.FinalCountCheckService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/f_count_check")
public class FCountCheckController
{
    @Autowired
    private FinalCountCheckService finalCountCheckService;
    @RequestMapping("find")
    public String find()
    {
        return "f_count_check_list";
    }
    @ResponseBody
    @RequestMapping("/list")
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
}
