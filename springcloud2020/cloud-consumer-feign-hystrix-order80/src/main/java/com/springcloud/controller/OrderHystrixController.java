package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/9/17 11:30
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/getok/{id}")
    public String getOk(@PathVariable("id") Integer id) {
        log.info("Hystrix80getOk" + id);
        return orderHystrixService.getOk(id);
    }

    @GetMapping("/consumer/payment/timeout/{id}")
    public String getTimeOut(@PathVariable("id") Integer id) {
        log.info("timeout          " + id);
        return orderHystrixService.getTimeOut(id);
    }

    public String getTimeOutHeader(Integer id) {
        log.info("消费者兜底方案" + id);
        return "支付提供方服务超时或者自身程序出错！" + id;
    }

    /**
     * 全局服务降级
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息,请稍后再试: orz~";
    }

}
