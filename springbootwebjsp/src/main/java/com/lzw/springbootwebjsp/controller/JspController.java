package com.lzw.springbootwebjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class JspController {
    @RequestMapping("/abc")
    public String testJsp(Model model){
        model.addAttribute("hello","你好啊jsp");
        return "success";
    }
}
