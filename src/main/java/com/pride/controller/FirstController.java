package com.pride.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
@RequestMapping("/erp")
@Controller
public class FirstController
{
   //首页
    @RequestMapping("/home")
    public String home(HttpSession httpSession,Model model)
    {
        return "home";
    }
}
