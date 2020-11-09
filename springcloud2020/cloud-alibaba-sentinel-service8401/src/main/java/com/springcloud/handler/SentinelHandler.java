package com.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.entity.CommonResult;

/**
 * @Author: Guo
 * @Date: 2020/10/15 14:17
 * 自定义异常返回方法
 * BlockException 必带  否则返回java.lang.reflect.UndeclaredThrowableException异常提醒
 */
public class SentinelHandler {
    public static CommonResult getSentinelHandler(BlockException e) {
        return new CommonResult(444, "自定义返回方法Handler");
    }
}
