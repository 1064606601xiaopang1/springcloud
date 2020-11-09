package com.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/9/10 15:05
 */
@RestController
@Slf4j
public class ConsumerConsulController {
    private final static String HOST_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/consul/get")
    public String getConsulClient() {
        return restTemplate.getForObject(HOST_URL + "/payment/consul", String.class);
    }
}
