package com.springcloud.service.impl;

import com.springcloud.dao.PaymentMapper;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/9/3 14:13
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getByPaymentId(Long id) {
        return paymentMapper.getByPaymentId(id);
    }
}
