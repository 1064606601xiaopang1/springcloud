package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Guo
 * @Date: 2020/10/20 15:40
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @RequestMapping("/Storage/{productId}")
    public String update(@PathVariable("productId") Long productId, @RequestParam("count") Integer count);
}
