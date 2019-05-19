package com.pride.controller.qualify;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Corder;
import com.pride.domain.UnqualifyApply;
import com.pride.domain.vo.UnqualifyApplyVO;
import com.pride.service.qualify.UnqualifyService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

}
