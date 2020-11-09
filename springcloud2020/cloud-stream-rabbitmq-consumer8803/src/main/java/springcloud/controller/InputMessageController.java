package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: Guo
 * @Date: 2020/10/12 16:59
 */
@Component
@Slf4j
@EnableBinding(Sink.class)
public class InputMessageController {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void inputMessage(Message<String> message) {
        log.info("端口为：" + port + "的消费者获取到的消息为：" + message.getPayload());
    }
}
