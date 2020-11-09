package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Guo
 * @Date: 2020/10/21 15:18
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SeataStorageMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2003.class, args);
    }
}
