package com.springcloud.controller;

import com.springcloud.dao.OrderDao;
import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Order;
import com.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/10/20 11:58
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String test() {
        orderService.create(new Order());
        return port;
    }

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public CommonResult order_create(@RequestBody Order data) {
        int i = orderService.create(data);
        if (i == 1) {
            return new CommonResult(200, "下单成功");
        }
        return new CommonResult(400, "程序出错");
    }
}
