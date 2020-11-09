package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Guo
 * @Date: 2020/10/13 11:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerMain83.class, args);
    }
}
