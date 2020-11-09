package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Guo
 * @Date: 2020/9/17 11:29
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = OrderHystrixServiceImpl.class)
public interface OrderHystrixService {
    @GetMapping("/payment/getok/{id}")
    public String getOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    public String getTimeOut(@PathVariable("id") Integer id);
}
