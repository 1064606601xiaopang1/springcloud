package com.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/9/10 12:10
 */
@RestController
@Slf4j
public class OrderZkController {
    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/zkconsumer/get")
    public String getZkClent() {
        return restTemplate.getForObject(PAYMENT_URL + "/zk/get", String.class);
    }
}
