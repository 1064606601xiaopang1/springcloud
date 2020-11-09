package com.springcloud.dao;

import com.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Guo
 * @Date: 2020/10/20 11:54
 */
@Mapper
public interface OrderDao {
    /**
     * 1 新建订单
     *
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 2 修改订单状态,从0改为1
     *
     * @param userId
     * @param status
     * @return
     */
    int update(@Param("userId") Long userId, @Param("status") Integer status);
}
