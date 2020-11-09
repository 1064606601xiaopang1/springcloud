package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Guo
 * @Date: 2020/10/13 10:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosMain9001.class, args);
    }
}
