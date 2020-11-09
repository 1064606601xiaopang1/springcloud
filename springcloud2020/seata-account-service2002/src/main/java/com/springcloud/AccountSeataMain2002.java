package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Guo
 * @Date: 2020/10/21 9:20
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AccountSeataMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(AccountSeataMain2002.class, args);
    }
}
