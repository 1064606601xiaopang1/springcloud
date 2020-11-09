package com.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author: Guo
 * @Date: 2020/10/20 11:54
 */
@Mapper
public interface AccountDao {
    public int update(@Param("userId") Long userId, @Param("used") BigDecimal used);
}
