package com.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Guo
 * @Date: 2020/9/15 15:55
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignloggerLevel() {
        return Logger.Level.FULL;
    }
}
