package com.springcloud.service.impl;

import com.springcloud.dao.StorageDao;
import com.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/10/21 15:25
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public String update(Long productId, Integer count) {
        int age = 10/0;
        storageDao.update(productId, count);
        return "1";
    }
}
