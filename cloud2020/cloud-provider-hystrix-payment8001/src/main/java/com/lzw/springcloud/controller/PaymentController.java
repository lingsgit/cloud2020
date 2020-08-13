package com.lzw.springcloud.controller;

import com.lzw.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @GetMapping("/paymentOk/{id}")
     public String paymentOk(@PathVariable("id") Integer id){
        return paymentService.paymentInfo(id);
    }

    @GetMapping("/paymentTimeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id){
        return paymentService.paymentTimeOut(id);
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuit(@PathVariable("id") Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        return s;
    }
}
