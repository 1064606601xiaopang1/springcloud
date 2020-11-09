package com.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author: Guo
 * @Date: 2020/10/21 9:26
 */
public interface AccountService {
    public String update(Long userId, BigDecimal used);
}
