package com.lzw.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    @PostMapping("/login")
    public String login(String username, String passwrod, Map map) {
        if (!StringUtils.isEmpty(username)&&"123456".equals(passwrod)){
            return "dashboard";
        }else{
            map.put("msg","用户名或密码错误！");
            return "login";
        }
    }
}
