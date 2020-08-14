package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.SentinelService;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @Autowired
    SentinelService sentinelService;

    @GetMapping("/testA")
    public String testA(){
    log.info(Thread.currentThread().getName()+"\t"+"testA");
        return Thread.currentThread().getName()+"\t"+"testA";
    }

    @GetMapping("/testB")
    public String testB(){
    log.info("Thread.currentThread().getName()"+"\t"+"testB");


        return Thread.currentThread().getName()+"\t"+"testB";
    }

    @GetMapping("/testC")
    public String testC(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("TR");

        log.info("异常比例");
        int i=1/0;
        return "testD";
    }
}
