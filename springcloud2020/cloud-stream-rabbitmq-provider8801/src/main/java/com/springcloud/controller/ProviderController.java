package com.springcloud.controller;

import com.springcloud.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/10/12 15:57
 */
@RestController
public class ProviderController {
    @Resource
    private ProviderService service;

    @GetMapping(value = "sendMessage")
    public String sendMessage() {
        return service.send();
    }
}
