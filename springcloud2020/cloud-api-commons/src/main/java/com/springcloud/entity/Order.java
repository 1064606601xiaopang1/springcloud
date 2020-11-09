package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Guo
 * @Date: 2020/10/19 17:38
 * 创建订单实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;
}
