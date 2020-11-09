package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.handler.SentinelHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Guo
 * @Date: 2020/10/15 12:00
 */
@RestController
@Slf4j
public class Sentinel2Controller {
    /**
     * 按照url和名称进行流控
     *
     * @return
     */
    @GetMapping(value = "/getLimiting")
    @SentinelResource(value = "getLimiting", blockHandler = "b_getLimiting")
    public CommonResult getLimiting() {
        return new CommonResult(200, "测试限流方法", new Payment((long) 0, "12"));
    }

    public CommonResult b_getLimiting(BlockException e) {
        return new CommonResult(444, "" + e.getClass().getName(), null);
    }

    @GetMapping(value = "/getcustom")
    @SentinelResource(value = "getcustom", blockHandlerClass = SentinelHandler.class, blockHandler = "getSentinelHandler")
    public CommonResult customHandler() {
        return new CommonResult(200, "自定义Handler方法", new Payment(1L, "3000"));
    }
}
