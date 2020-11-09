package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Guo
 * @Date: 2020/10/20 11:57
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OrderSeataMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderSeataMain2001.class, args);
    }
}
