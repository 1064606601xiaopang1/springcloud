package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Guo
 * @Date: 2020/10/19 17:41
 * 用户账户表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private Long id;
    private Long userId;
    /**
     * 总额度
     */
    private BigDecimal total;
    /**
     * 使用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
