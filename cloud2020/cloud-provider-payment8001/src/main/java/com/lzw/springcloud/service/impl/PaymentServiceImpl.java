package com.lzw.springcloud.service.impl;

import com.lzw.springcloud.dao.PaymentDao;
import com.lzw.springcloud.entities.Payment;
import com.lzw.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName cloud2020
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/9 18:12
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
