package com.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Guo
 * @Date: 2020/10/21 15:19
 */
@Mapper
public interface StorageDao {
    int update(@Param("productId") Long productId, @Param("count") Integer count);
}
