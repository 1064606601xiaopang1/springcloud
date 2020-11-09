package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Guo
 * @Date: 2020/9/3 11:47
 */
@SpringBootApplication
@EnableEurekaClient
public class PayMent8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8001.class, args);
    }
}
