package com.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Guo
 * @Date: 2020/10/20 15:37
 */
@Configuration
@MapperScan({"com.springcloud.dao"})
public class MyBatisConfig {
}
