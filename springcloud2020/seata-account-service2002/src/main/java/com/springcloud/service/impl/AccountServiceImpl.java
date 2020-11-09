package com.springcloud.service.impl;

import com.springcloud.dao.AccountDao;
import com.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: Guo
 * @Date: 2020/10/21 9:27
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public String update(Long userId, BigDecimal used) {
        accountDao.update(userId, used);
        return "修改账户";
    }
}
