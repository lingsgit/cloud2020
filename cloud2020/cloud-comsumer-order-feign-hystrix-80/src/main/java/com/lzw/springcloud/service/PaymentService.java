package com.lzw.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFullBackService.class)
public interface PaymentService {
    @GetMapping("/paymentOk/{id}")
    public String paymentOk(@PathVariable("id") Integer id);


    @GetMapping("/paymentTimeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id);


}
