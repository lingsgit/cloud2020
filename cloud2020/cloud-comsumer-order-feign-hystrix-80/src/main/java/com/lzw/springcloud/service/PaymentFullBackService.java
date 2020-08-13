package com.lzw.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFullBackService implements PaymentService{
    @Override
    public String paymentOk(Integer id) {
        return "PaymentFullBackService paymentOk";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return "PaymentFullBackService paymentTimeOut";
    }
}
