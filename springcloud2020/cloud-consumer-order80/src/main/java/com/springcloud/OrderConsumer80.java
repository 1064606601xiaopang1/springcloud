package com.springcloud;

import com.myrule.MyIrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: Guo
 * @Date: 2020/9/3 15:15
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyIrule.class)
public class OrderConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer80.class, args);
    }
}
