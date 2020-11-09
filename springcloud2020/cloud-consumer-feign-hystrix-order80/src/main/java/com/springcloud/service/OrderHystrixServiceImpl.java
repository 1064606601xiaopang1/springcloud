package com.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: Guo
 * @Date: 2020/9/17 17:48
 */
@Component
public class OrderHystrixServiceImpl implements OrderHystrixService {
    @Override
    public String getOk(Integer id) {
        return "正常返回";
    }

    @Override
    public String getTimeOut(Integer id) {
        return "超时了啊";
    }
}
