package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Guo
 * @EnableDiscoveryClient //该注解用于想使用consul或者zookeeper作为注册中心时注册服务
 * @Date: 2020/9/9 16:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PayMent8004 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8004.class, args);
    }
}
