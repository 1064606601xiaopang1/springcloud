package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Guo
 * @Date: 2020/9/3 11:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain9003.class, args);
    }
}
