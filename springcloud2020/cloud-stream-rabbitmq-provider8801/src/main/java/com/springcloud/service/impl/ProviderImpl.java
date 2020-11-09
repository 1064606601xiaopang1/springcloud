package com.springcloud.service.impl;

import com.springcloud.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: Guo
 * @Date: 2020/10/12 15:48
 * @EnableBinding({Source.class}) 定义消息的推送管理
 */
@EnableBinding(Source.class)
@Slf4j
public class ProviderImpl implements ProviderService {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        log.info("得到的流水号：" + s);
        return null;
    }
}
