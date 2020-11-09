package com.springcloud;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Guo
 * @Date: 2020/9/10 12:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConSumerZKMain {
    public static void main(String[] args) {
        SpringApplication.run(ConSumerZKMain.class, args);
    }
}
