package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.srvice.PaymentService;
import com.sun.xml.internal.ws.handler.HandlerException;
import feign.Param;
import io.netty.handler.timeout.ReadTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Map;

/**
 * @Author: Guo
 * @Date: 2020/10/15 19:53
 */
@RestController
@Slf4j
public class ConsumerNacosController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private RestTemplate restTemplate;

    private final static String PAYMENT_URL = "http://nacos-alibaba-payment";

    @GetMapping("/consumer/order/getPayment/{id}")
    @SentinelResource(value = "getPayment", blockHandler = "c_getPayment", fallback = "f_getPayment")
    public CommonResult queryPayment(@PathVariable("id") Long id) {
//        log.info("" + PAYMENT_URL + "/payment/getPayment?id=" + id);
//        CommonResult result = restTemplate.getForObject("http://localhost:9003/payment/getPayment?id=" + id, CommonResult.class);
        CommonResult forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/getPayment/" + id, CommonResult.class);
        // 500为未找到数据
        if (forObject.getCode().equals(500)) {
            return new CommonResult(500, "null异常");
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            Payment payment = objectMapper.convertValue(forObject.getData(), Payment.class);
            log.info(payment.toString());
            if (payment.getSerial().equals("张三")) {
                throw new IllegalArgumentException("测试异常！");
            }
            return forObject;
        }
    }

    public CommonResult c_getPayment(@PathVariable("id") Long id, BlockException e) {
        return new CommonResult(400, "blockHandler兜底方法");
    }

    public CommonResult f_getPayment(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(455, "抛出异常了：" + e.getMessage(), payment);
    }


    @GetMapping("/test")
    @SentinelResource(value = "test", fallback = "exceptionError", blockHandler = "blockHandler")
    public String test() {
        throw new RuntimeException("测试异常");
    }

    public String exceptionError(Throwable t) {
        return "exceptionError";
    }

    public String blockHandler(BlockException b) {
        return "blockHandler";
    }


    @GetMapping("/consumr/Feign/{id}")
    @SentinelResource(value = "feign", fallback = "error_feign")
    public CommonResult Feign(@PathVariable("id") Long id) {
        CommonResult byPaymentId = paymentService.getByPaymentId(id);
        Object data = byPaymentId.getData();
        ObjectMapper objectMapper = new ObjectMapper();
        Payment payment = objectMapper.convertValue(data, Payment.class);
        if (payment.getSerial().equals("张三")) {
            throw new RuntimeException("不能为张三");
        }
        return byPaymentId;
    }

    public CommonResult error_feign(@PathVariable("id") Long id, Throwable throwable) {
        return new CommonResult(444444, id + "出现异常了，异常兜底" + throwable.getMessage(), new Payment(id, null));
    }
}
