package com.lzw.springcloud.controller;

import com.lzw.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@DefaultProperties(defaultFallback = "globalHandler")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return paymentService.paymentOk(id);
    }

    @GetMapping("/consumer/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String timeout(@PathVariable("id") Integer id){
       int i= 1/0;
        return paymentService.paymentTimeOut(id);
    }

    public String paymentTimeOutHandler(Integer id){
        return "I IM 消费者 超时了";
    }


    public String globalHandler(){
        return "globalHandler  :I IM 消费者 超时了";
    }
}
