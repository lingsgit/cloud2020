package com.lzw.springcloud.alibaba.controller;

import com.lzw.springcloud.alibaba.domain.CommonResult;
import com.lzw.springcloud.alibaba.domain.Order;
import com.lzw.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName cloud2020
 * @ClassName OrderController
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/15 0:51
 * @Version 1.0
 **/
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
