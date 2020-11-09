package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Guo
 * @Date: 2020/10/12 12:33
 */
@RestController
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;  //要访问的3344上的信息

    @GetMapping("/configInfo")    //请求地址
    public String getConfigInfo() {
        return configInfo;
    }
}
