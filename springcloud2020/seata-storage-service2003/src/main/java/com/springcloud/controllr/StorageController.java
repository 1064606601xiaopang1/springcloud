package com.springcloud.controllr;

import com.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.GetAppletMessage;

import javax.annotation.Resource;

/**
 * @Author: Guo
 * @Date: 2020/10/21 15:26
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/Storage/{productId}", method = RequestMethod.GET)
    public String update(@PathVariable("productId") Long productId, @Param("count") int count) {
        log.info("库存修改" + productId+"_________"+count);
        storageService.update(productId, count);
        return "修改库存";
    }
}
