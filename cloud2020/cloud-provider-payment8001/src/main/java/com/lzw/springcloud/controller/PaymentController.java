package com.lzw.springcloud.controller;

import com.lzw.springcloud.entities.CommonResult;
import com.lzw.springcloud.entities.Payment;
import com.lzw.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName cloud2020
 * @ClassName paymentController
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/9 18:14
 * @Version 1.0
 **/
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private static final  Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Value("${server.port}")
    private String serverPort;

    @Resource
    PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;//服务发现

    @GetMapping("/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("*****查询结果***"+paymentById);
        if(paymentById!=null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,paymentById);
        }else{
            return new CommonResult(444,"没有对应记录，ID为："+id+",serverPort:"+serverPort);
        }
    }


    @PostMapping("/payment")
    public CommonResult create(@RequestBody Payment payment){
        log.info("*****插入接收***"+payment);
        int i = paymentService.create(payment);
        log.info("*****插入结果***"+i);
        if(i>0){
            return new CommonResult(200,"插入成功,serverPort:"+serverPort,i);
        }else{
            return new CommonResult(444,"插入失败,serverPort:"+serverPort);
        }
    }
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(x->log.info("*************element:"+x));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(x->log.info(x.getServiceId()+"\t"+x.getHost()+"\t"+x.getUri()));
        return this.discoveryClient;
    }

    @GetMapping("/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/gateway1/{id}")
    public String gateway1(@PathVariable("id")Integer id){

        return serverPort+"\t gateway1"+"\t"+id;
    }

    @GetMapping("/gateway2/{id}")
    public String gateway2(@PathVariable("id")Integer id){

        return serverPort+"\t gateway2"+"\t"+id;
    }

    @GetMapping("/getPort")
    public String getPort(){

        return serverPort;
    }
}
