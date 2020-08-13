package com.lzw.springcloud.controller;

import com.lzw.springcloud.service.impl.MessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName cloud2020
 * @ClassName SendMessageController
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/13 23:04
 * @Version 1.0
 **/
@RestController
public class SendMessageController {
    @Resource
    MessageProviderImpl messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
