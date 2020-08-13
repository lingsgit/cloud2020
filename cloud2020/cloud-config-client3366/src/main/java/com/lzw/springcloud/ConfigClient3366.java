package com.lzw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName cloud2020
 * @ClassName ConfigClient3366
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/13 20:54
 * @Version 1.0
 **/

    @SpringBootApplication
    @EnableEurekaClient

    public class ConfigClient3366 {
        public static void main(String[] args) {
            SpringApplication.run(ConfigClient3366.class,args);
        }
    }
