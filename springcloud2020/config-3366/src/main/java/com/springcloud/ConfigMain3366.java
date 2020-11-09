package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Guo
 * @Date: 2020/10/12 12:32
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3366.class, args);
    }
}
