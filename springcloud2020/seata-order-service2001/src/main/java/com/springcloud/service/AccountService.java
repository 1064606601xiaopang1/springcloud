package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author: Guo
 * @Date: 2020/10/20 15:39
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @RequestMapping("/account/{userId}")
    public String update(@PathVariable("userId") Long userId, @RequestParam("used") BigDecimal used);
}
