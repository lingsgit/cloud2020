package com.lzw.springcloud.alibaba.service.impl;

import com.lzw.springcloud.alibaba.dao.OrderDao;
import com.lzw.springcloud.alibaba.domain.Order;
import com.lzw.springcloud.alibaba.service.AccountService;
import com.lzw.springcloud.alibaba.service.OrderService;
import com.lzw.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName cloud2020
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/15 0:38
 * @Version 1.0
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("----->开始新建订单");
        orderDao.create(order);
        log.info("----->订单微服务开始调用库存，做减扣count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做减扣结束");
        log.info("----->订单微服务开始调用账户，做减扣money");
        accountService.decrease(order.getUesrId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做减扣money结束");
        log.info("----->修改订单状态 0-->1");
        orderDao.update(order.getUesrId(), 0);
        log.info("----->修改订单状态 0-->1 end");
        log.info("----->订单结束");
    }
}
