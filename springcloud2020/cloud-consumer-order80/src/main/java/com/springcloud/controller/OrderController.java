package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.rule.MyRuleBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Guo
 * @Date: 2020/9/3 15:32
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private MyRuleBalance myRuleBalance;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private RestTemplate restTemplate;
    // 写死的访问实例   配置多个实例名字为一样的一样时，会报错为org.springframework.web.client.HttpClientErrorException$NotFound: 404 : [{"timestamp":"2020-09-09T03:21:31.644+0000","status":404,"error":"Not Found","message":"No message available","path":"/payment/get/1"}]
//    public static final String PAY_URL = "http://localhost:8001/payment/";
    /**
     * 配置访问实例
     */
    public static final String PAY_URL = "http://CLOUD-PAYMENT-SERVICE/payment/";

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment) {
        log.info("消费者创建订单" + payment);
        return restTemplate.postForObject(PAY_URL + "create", payment, CommonResult.class);
    }


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getByPaymentId(@PathVariable Long id) {
        System.out.println("PAY_URL = " + PAY_URL);
        log.info("消费者查询订单" + id);
        return restTemplate.getForObject(PAY_URL + "get/" + id, CommonResult.class);
    }


    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult getByGetForEntity(@PathVariable Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAY_URL + "get/" + id, CommonResult.class);
        log.info(forEntity.toString());
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            CommonResult body = forEntity.getBody();
            return new CommonResult(200, "查询成功", body);
        } else {
            return new CommonResult(500, "未找到数据", null);
        }
    }

    /**
     * 测试自定义轮询策略
     * 使用本方法注意注视注解  LoadBalanced
     *
     * @return
     * @LoadBalanced com.springcloud.config.RestTemplateConfig
     */
    @GetMapping(value = "/consumer/payment/serverPort")
    public CommonResult getServerPort() {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instanceList == null || instanceList.size() <= 0) {
            return new CommonResult(400, "未找到实例数据", null);
        } else {
            ServiceInstance instance = myRuleBalance.instance(instanceList);
            System.out.println(instance.getUri() + "/payment/serverPort");
            String forObject = restTemplate.getForObject(instance.getUri() + "/payment/serverPort", String.class);
            return new CommonResult(200, "查询成功", forObject);

        }
    }
}
