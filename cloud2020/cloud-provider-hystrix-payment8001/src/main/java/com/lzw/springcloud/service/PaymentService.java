package com.lzw.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo(Integer id){
        return "线程池"+Thread.currentThread().getName()+" paymentId "+id+" O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentTimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+" TimeOutpaymentId "+id+" o(╥﹏╥)o";
    }

    public String paymentTimeOutHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+" TimeOutpaymentId "+id+" (*^▽^*)";
    }

    //熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fullback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(Integer id){
       if(id<0){
           throw new RuntimeException("id 不能为负数");
       }
        String s = IdUtil.simpleUUID();
        return "线程池"+Thread.currentThread().getName()+" 调用成功,流水号 "+s;
    }

    public String paymentCircuitBreaker_fullback(Integer id){
        return "id 不能为负数,请稍后再试"+id;
    }
}
