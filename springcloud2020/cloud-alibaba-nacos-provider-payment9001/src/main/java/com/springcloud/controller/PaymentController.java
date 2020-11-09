package com.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Guo
 * @Date: 2020/10/13 10:57
 */
@RestController
@Slf4j
public class PaymentController {
    /**
     * 端口号
     */
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/port")
    public String getPort() {
        log.info(serverPort);
        return "获取到的端口号为" + serverPort;
    }
}
