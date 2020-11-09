package com.springcloud.srvice;

import com.springcloud.entity.CommonResult;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Guo
 * @Date: 2020/10/16 11:25
 */
@FeignClient(value = "nacos-alibaba-payment", fallback = PaymentServerFallback.class)
public interface PaymentService {
    @GetMapping(value = "/payment/getPayment/{id}")
    public CommonResult getByPaymentId(@PathVariable("id") Long id);

    @GetMapping(value = "payment/get")
    public CommonResult get();
}
