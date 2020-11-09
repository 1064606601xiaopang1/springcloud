package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Guo
 * @Date: 2020/9/15 14:51
 */
@SpringBootApplication
@EnableFeignClients
public class FeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignMain80.class, args);
    }
}
