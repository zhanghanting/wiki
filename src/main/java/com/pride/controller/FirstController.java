package com.pride.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/erp")
@Controller
public class FirstController
{
   //首页
    @RequestMapping("/home")
    public String home(HttpSession httpSession, HttpServletRequest request,Model model)
    {
        HttpSession session = request.getSession();
        List<String> sysPermissionList = new ArrayList();
        sysPermissionList.add("custom:add");
        sysPermissionList.add("custom:edit");
        sysPermissionList.add("custom:delete");

        sysPermissionList.add("order:add");
        sysPermissionList.add("order:edit");
        sysPermissionList.add("order:delete");

        sysPermissionList.add("work:add");
        sysPermissionList.add("work:edit");
        sysPermissionList.add("work:delete");

        sysPermissionList.add("task:add");
        sysPermissionList.add("task:edit");
        sysPermissionList.add("task:delete");

        sysPermissionList.add("manufacture:add");
        sysPermissionList.add("manufacture:edit");
        sysPermissionList.add("manufacture:delete");

        sysPermissionList.add("product:add");
        sysPermissionList.add("product:edit");
        sysPermissionList.add("product:delete");
        /**
         * the next five module`s author:Zhanghanting
         */

        //不合格品管理
        sysPermissionList.add("unqualify:add");
        sysPermissionList.add("unqualify:edit");
        sysPermissionList.add("unqualify:delete");

        //成品计量检测
        sysPermissionList.add("fMeasureCheck:add");
        sysPermissionList.add("fMeasureCheck:edit");
        sysPermissionList.add("fMeasureCheck:delete");

        //成品计数检测
        sysPermissionList.add("fCountCheck:add");
        sysPermissionList.add("fCountCheck:edit");
        sysPermissionList.add("fCountCheck:delete");

        //工序计量检测
        sysPermissionList.add("pMeasureCheck:add");
        sysPermissionList.add("pMeasureCheck:edit");
        sysPermissionList.add("pMeasureCheck:delete");

        //工序计数检测
        sysPermissionList.add("pCountCheck:add");
        sysPermissionList.add("pCountCheck:edit");
        sysPermissionList.add("pCountCheck:delete");

        //设备管理
        sysPermissionList.add("device:add");
        sysPermissionList.add("device:edit");
        sysPermissionList.add("device:delete");
        sysPermissionList.add("deviceType:add");
        sysPermissionList.add("deviceType:edit");
        sysPermissionList.add("deviceType:delete");
        /**
         * the next four module`s author:Lishuo
         */
        //工艺监控-工艺管理
        sysPermissionList.add("technology:add");
        sysPermissionList.add("technology:edit");
        sysPermissionList.add("technology:delete");
        //工艺监控-工艺要求
        sysPermissionList.add("technologyRequirement:add");
        sysPermissionList.add("technologyRequirement:edit");
        sysPermissionList.add("technologyRequirement:delete");
        //工艺监控-工艺计划
        sysPermissionList.add("technologyPlan:add");
        sysPermissionList.add("technologyPlan:edit");
        sysPermissionList.add("technologyPlan:delete");
        //工艺监控-工序管理
        sysPermissionList.add("process:add");
        sysPermissionList.add("process:edit");
        sysPermissionList.add("process:delete");

        //物料监控-物料信息
        sysPermissionList.add("material:add");
        sysPermissionList.add("material:edit");
        sysPermissionList.add("material:delete");
        //物料监控-物料收入
        sysPermissionList.add("materialReceive:add");
        sysPermissionList.add("materialReceive:edit");
        sysPermissionList.add("materialReceive:delete");
        //物料监控-物料消耗
        sysPermissionList.add("materialConsume:add");
        sysPermissionList.add("materialConsume:edit");
        sysPermissionList.add("materialConsume:delete");

        session.setAttribute("sysPermissionList",sysPermissionList);
        return "home";
    }
}
