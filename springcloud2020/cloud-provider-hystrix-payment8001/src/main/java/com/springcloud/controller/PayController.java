package com.springcloud.controller;

import com.springcloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/9/17 11:13
 */
@RestController
@Slf4j
public class PayController {
    @Resource
    private PayService payService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/getok/{id}")
    public String getOk(@PathVariable("id") Integer id) {
        log.info("正常进入！");
        return payService.getOk(id) + "*************serverPort:" + serverPort;
    }

    @GetMapping("/payment/timeout/{id}")
    public String getTimeOut(@PathVariable("id") Integer id) throws InterruptedException {
        log.info("进入延时任务！");
        String timeOut = payService.getTimeOut(id);
        log.info(timeOut);
        return timeOut + "*************serverPort:" + serverPort;
    }

    //    ***************服务熔断************************
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String circuitBreaker = payService.paymentCircuitBreaker(id);
        log.info("******result: " + circuitBreaker);
        return circuitBreaker;
    }

}
