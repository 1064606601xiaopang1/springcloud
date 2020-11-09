package com.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Guo
 * @Date: 2020/9/17 11:06
 */
@Service
public class PayServiceImpl implements PayService {
    @Override
    public String getOk(Integer id) {
        return "当前线程" + Thread.currentThread().getName() + "        getOk:id" + id;
    }

    /**
     * 程序运行时间超过3秒钟就执行兜底方案（服务降级）
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String getTimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "         getTimeOut:id" + id;
    }

    public String getTimeOutHandler(Integer id) {
        return Thread.currentThread().getName() + "8001系统出错或者系统繁忙，实施兜底方案：" + id;
    }


    // 服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数s
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期 1000ms=1s"
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException();
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t " + "调用成功,流水号: " + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id不能为负数,请稍后再试~ id: " + id;
    }


    public static void main(String[] args) {
        PayServiceImpl payService = new PayServiceImpl();
        boolean odd = payService.isOdd(2);
        System.out.println("odd = " + odd);
    }

    public boolean isOdd(int num) {
        return num % 2 == 1;
    }

}
