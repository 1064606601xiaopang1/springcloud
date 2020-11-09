package com.springcloud.srvice;

import com.springcloud.entity.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Author: Guo
 * @Date: 2020/10/16 11:26
 * 兜底方法   降级时调用
 */
@Component
public class PaymentServerFallback implements PaymentService {
    @Override
    public CommonResult getByPaymentId(Long id) {
        return new CommonResult(444, "限流方法");
    }

    @Override
    public CommonResult get() {
        return new CommonResult(444, "获取端口限流方法");
    }
}
