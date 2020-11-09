package com.springcloud.service.impl;

import com.springcloud.dao.OrderDao;
import com.springcloud.entity.Order;
import com.springcloud.service.AccountService;
import com.springcloud.service.OrderService;
import com.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/10/20 15:33
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "order_group", rollbackFor = Exception.class)
    public int create(Order order) {
        log.info("用户开始下订单......");
        orderDao.create(order);
//
        log.info("开始更新库存......");
        String result01 = storageService.update(order.getProductId(), order.getCount());
        log.info("库存更新成功......");
//
//        int a = 10 / 0;
//
        log.info("开始更新用户账户......");
        log.info(order.getUserId() + "____" + order.getMoney());
        String result02 = accountService.update(order.getUserId(), order.getMoney());
        log.info("账户更新结束......");
//
//
        int result03 = orderDao.update(order.getUserId(), 0);
        log.info("订单操作结束......");
        return 1;
    }
}
