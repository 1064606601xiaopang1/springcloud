package com.springcloud.service;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: Guo
 * @Date: 2020/9/15 14:53
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderFeignService {
    @PostMapping(value = "/payment/create")
    CommonResult<Integer> create(Payment payment);

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getByPaymentId(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    CommonResult<String> getTimeOut();
}
