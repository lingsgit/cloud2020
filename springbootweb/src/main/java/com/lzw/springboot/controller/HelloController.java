package com.lzw.springboot.controller;

import com.lzw.springboot.exception.UserNotExistExption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/success")
    public String testHtml(Map map,@RequestParam("user") String user){
        if(user.equals("aaa")){
           throw new UserNotExistExption();
        }
        map.put("hello","你好啊");
        return "success";
    }
}
