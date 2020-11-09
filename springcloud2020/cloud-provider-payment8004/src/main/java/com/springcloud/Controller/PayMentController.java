package com.springcloud.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: Guo
 * @Date: 2020/9/9 16:14
 */
@RestController
@Slf4j
public class PayMentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/zk/get")
    public String paymentzk() {
        return "Spring cloud with zk port: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
