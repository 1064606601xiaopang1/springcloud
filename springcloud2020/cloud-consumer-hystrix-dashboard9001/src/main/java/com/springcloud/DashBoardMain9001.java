package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: Guo
 * @Date: 2020/9/21 14:35
 */
@SpringBootApplication
@EnableHystrixDashboard // 图形化监控
public class DashBoardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoardMain9001.class, args);
    }
}
