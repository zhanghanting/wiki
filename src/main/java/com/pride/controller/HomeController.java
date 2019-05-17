package com.pride.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("erp")
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}
