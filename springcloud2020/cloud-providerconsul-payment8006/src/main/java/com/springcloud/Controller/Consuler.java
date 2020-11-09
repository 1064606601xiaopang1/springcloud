package com.springcloud.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: Guo
 * @Date: 2020/9/10 14:38
 */
@RestController
@Slf4j
public class Consuler {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "Spring cloud with consul port: " + serverPort + "\t  " + UUID.randomUUID().toString();
    }
}
