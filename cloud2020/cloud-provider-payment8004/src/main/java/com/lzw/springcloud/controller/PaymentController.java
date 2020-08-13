package com.lzw.springcloud.controller;

import com.lzw.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:serverPort:"+port+"\t"+ UUID.randomUUID().toString();
    }
}
