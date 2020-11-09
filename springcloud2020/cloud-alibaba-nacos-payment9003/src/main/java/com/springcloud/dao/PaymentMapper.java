package com.springcloud.dao;

import com.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Guo
 * @Date: 2020/9/3 13:50
 */
@Mapper
public interface PaymentMapper {
    public int create(Payment payment);

    public Payment getByPaymentId(@Param("id") Long id);
}
