package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/9/3 14:15
 */
@RestController
@Slf4j
public class PaymentController {
    /**
     * 端口号获取
     */
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info(payment.toString());
        int i = paymentService.create(payment);
        if (i > 0) {
            return new CommonResult(200, "插入数据成功" + serverPort, i);
        } else {
            return new CommonResult(500, "插入数据失败", null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getByPaymentId(@PathVariable("id") Long id) {
        Payment payment = paymentService.getByPaymentId(id);
        log.info("查询结果--" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功" + serverPort, payment);
        } else {
            return new CommonResult(500, "未找到数据id为" + id + "的数据，请检查！", null);
        }
    }

    @GetMapping(value = "payment/get")
    public CommonResult get() {
        return new CommonResult(200, "测试成功,端口号为" + serverPort, null);
    }

    /**
     * 获得端口号
     *
     * @return
     */
    @GetMapping("payment/serverPort")
    public String getByPort() {
        return serverPort;
    }

    @GetMapping("payment/timeout")
    public CommonResult timeOut() throws InterruptedException {
        // 模拟义务逻辑
        Thread.sleep(3000);
        return new CommonResult(200, "处理成功", serverPort);
    }
}
