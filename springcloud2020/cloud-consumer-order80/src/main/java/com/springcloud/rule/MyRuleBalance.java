package com.springcloud.rule;

import com.sun.xml.internal.ws.api.client.ServiceInterceptor;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: Guo
 * @Date: 2020/9/15 11:38
 */
public interface MyRuleBalance {
    ServiceInstance instance(List<ServiceInstance> list);
}
