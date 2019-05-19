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

        sysPermissionList.add("unqualify:add");
        sysPermissionList.add("unqualify:edit");
        sysPermissionList.add("unqualify:delete");

        sysPermissionList.add("technology:add");
        sysPermissionList.add("technology:edit");
        sysPermissionList.add("technology:delete");

        sysPermissionList.add("device:add");
        sysPermissionList.add("device:edit");
        sysPermissionList.add("device:delete");
        sysPermissionList.add("deviceType:add");
        sysPermissionList.add("deviceType:edit");
        sysPermissionList.add("deviceType:delete");

        sysPermissionList.add("technologyRequirement:add");
        sysPermissionList.add("technologyRequirement:edit");
        sysPermissionList.add("technologyRequirement:delete");
<<<<<<< HEAD
        sysPermissionList.add("technologyPlan:add");
        sysPermissionList.add("technologyPlan:edit");
        sysPermissionList.add("technologyPlan:delete");
        sysPermissionList.add("process:add");
        sysPermissionList.add("process:edit");
        sysPermissionList.add("process:delete");

=======
>>>>>>> a28bc006b25812a4765c5ed9a0d4b33339a483a8

        session.setAttribute("sysPermissionList",sysPermissionList);
        return "home";
    }
}
