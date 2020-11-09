package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Guo
 * @Date: 2020/9/3 11:47
 */
@SpringBootApplication
@EnableEurekaClient
public class PayMent8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8002.class, args);
    }
}
