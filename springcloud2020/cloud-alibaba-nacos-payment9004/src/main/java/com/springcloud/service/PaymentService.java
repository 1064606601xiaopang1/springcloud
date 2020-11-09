package com.springcloud.service;

import com.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Guo
 * @Date: 2020/9/3 14:12
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getByPaymentId(@Param("id") Long id);
}
