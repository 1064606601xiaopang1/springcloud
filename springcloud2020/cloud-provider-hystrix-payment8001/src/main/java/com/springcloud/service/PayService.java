package com.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Guo
 * @Date: 2020/9/17 11:05
 */
public interface PayService {
    public String getOk(Integer id);

    public String getTimeOut(Integer id) throws InterruptedException;

    public String paymentCircuitBreaker(Integer id);
}
