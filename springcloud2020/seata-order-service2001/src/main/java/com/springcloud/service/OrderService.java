package com.springcloud.service;

import com.springcloud.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Guo
 * @Date: 2020/10/20 15:32
 */
public interface OrderService {
    /**
     * 1 新建订单
     *
     * @param order
     * @return
     */
    int create(Order order);
}
