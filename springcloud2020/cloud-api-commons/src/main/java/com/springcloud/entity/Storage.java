package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Guo
 * @Date: 2020/10/19 17:44
 * 库存表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage implements Serializable {
    private Long id;
    private Long productId;
    /**
     * 总库存
     */
    private Integer total;
    /**
     * 使用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}
