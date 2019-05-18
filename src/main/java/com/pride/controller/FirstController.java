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
        sysPermissionList.add("technology:add");
        sysPermissionList.add("technology:edit");
        sysPermissionList.add("technology:delete");

        session.setAttribute("sysPermissionList",sysPermissionList);
        return "home";
    }
}
