package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Guo
 * @Date: 2020/9/15 10:38
 * 创建自定义负载策略
 */
@Configuration
public class MyIrule {
    @Bean
    public IRule myrule() {
        // 随机   12 21 11 2 221
        return new RandomRule();
    }
}
