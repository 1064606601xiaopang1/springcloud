package com.springcloud.controller;

import com.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: Guo
 * @Date: 2020/10/21 9:29
 */
@RestController
@Slf4j
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/account/{userId}", method = RequestMethod.GET)
    public String update(@PathVariable("userId") Long userId, @Param("used") BigDecimal used) {
        log.info(userId + "" + used);
        accountService.update(userId, used);
        return "修改账户余额成功";
    }
}
