package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/9/15 14:57
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private OrderFeignService orderFeignService;

    /**
     * feign测试
     *
     * @param id
     * @return
     */
    @GetMapping(value = "consumer/feignOrder/get/{id}")
    public CommonResult get(@PathVariable Long id) {
        log.info("获取到的查询id" + id);
        CommonResult<Payment> byPaymentId = orderFeignService.getByPaymentId(id);
        if (byPaymentId == null) {
            return new CommonResult(200, "暂未找到数据", null);
        }
        return byPaymentId;
    }


    @GetMapping(value = "consumer/feignOrder/timeOut")
    public CommonResult timeOut() {
        CommonResult<String> timeOut = orderFeignService.getTimeOut();
        return timeOut;
    }
}
