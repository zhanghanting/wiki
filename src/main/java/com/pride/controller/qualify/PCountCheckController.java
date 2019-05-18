package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.vo.ProcessCountCheckVO;
import com.pride.service.qualify.ProcessCountCheckService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/p_count_check")
public class PCountCheckController
{
    @Autowired
    ProcessCountCheckService processCountCheckService;
    @RequestMapping("/find")
    public String find()
    {
        return "p_count_check_list";
    }
    @ResponseBody
    @RequestMapping("/list")
    public MyPageHelper<ProcessCountCheckVO> getList(Integer page,Integer rows)
    {
        PageHelper.startPage(page,rows);
        //获取工序计数的所有信息
        List<ProcessCountCheckVO> processCountCheckVOS = processCountCheckService.queryProcessCountCheckVO();
        //将获取的信息封装为page
        PageInfo<ProcessCountCheckVO> processCountCheckVOPageInfo = new PageInfo<>(processCountCheckVOS);
        MyPageHelper myPageHelper = new MyPageHelper();
        myPageHelper.setRows(processCountCheckVOS);
        myPageHelper.setTotal(processCountCheckVOPageInfo.getTotal());
        return myPageHelper;
    }


}
