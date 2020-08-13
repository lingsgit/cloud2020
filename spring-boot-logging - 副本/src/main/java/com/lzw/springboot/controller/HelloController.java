package com.lzw.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/success")
    public String testHtml(Map map){
        map.put("hello","你好啊");
        return "success";
    }
}
