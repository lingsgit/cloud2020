package com.lzw.springcloud.controller;

import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName cloud2020
 * @ClassName OrderController
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/9 18:53
 * @Version 1.0
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment")
    public CommonResult<Payment> create(Payment Payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/payment", Payment,CommonResult.class);
    }


    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/payment/"+id,CommonResult.class);
    }
}
