package com.lzw.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


/**
 * @ProjectName cloud2020
 * @ClassName MybatisConfig
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/15 0:54
 * @Version 1.0
 **/
@Configuration
@MapperScan({"com.lzw.springcloud.alibaba.dao"})
public class MybatisConfig {

}
