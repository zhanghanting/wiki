package com.pride.controller.technology;


import com.pride.domain.vo.TechnologyRequirementVO;
import com.pride.service.technology.TechnologyRequirementService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/19 10:53
 */

@Controller
@RequestMapping("/erp/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    private TechnologyRequirementService technologyRequirementService;

    //返回technologyRequirement_list页面
    @RequestMapping("/find")
    public String find(){
        return "technologyRequirement_list";
    }

    //返回分页的TechnologyRequirement的list
    @RequestMapping("/list")
    @ResponseBody
    public MyPageHelper getItemList(Integer page, Integer rows, TechnologyRequirementVO technologyRequirementPO){
        MyPageHelper result = technologyRequirementService.getList(page,rows,technologyRequirementPO);
        return result;
    }
}
