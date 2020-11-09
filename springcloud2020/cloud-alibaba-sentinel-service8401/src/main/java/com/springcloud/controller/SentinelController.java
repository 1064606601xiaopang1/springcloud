package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Guo
 * @Date: 2020/10/14 15:45
 */
@RestController
@Slf4j
public class SentinelController {
    @GetMapping(value = "/getA")
    public CommonResult<String> getValue() {
        return new CommonResult<>(200, "A", null);
    }

    @GetMapping(value = "/getB")
    public CommonResult<String> value() {
        SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(smp.format(new Date()));
        return new CommonResult<>(200, "B", null);
    }

    @GetMapping(value = "/getD")
    public CommonResult getD() {
        try {
            // 延时一秒
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CommonResult(200, "RT", null);
    }


    /**
     * @param p1
     * @param p2
     * @return
     * @SentinelResource blockHandler异常方法
     * required 非必填（必传）
     * blockHandleer触发热点限制时候调用的方法   需注意异常参数BlockException必填
     */
    @GetMapping(value = "/hotskey")
    @SentinelResource(value = "hotskey", blockHandler = "bot_hotskey")
    public CommonResult getLockBack(@RequestParam(value = "p1", required = false) String p1,
                                    @RequestParam(value = "p2", required = false) String p2) {
        return new CommonResult(200, "热点key限流", null);
    }

    public CommonResult bot_hotskey(String p1, String p2, BlockException e) {
        return new CommonResult(500, "这个热点key限流兜底方法", null);
    }
}
