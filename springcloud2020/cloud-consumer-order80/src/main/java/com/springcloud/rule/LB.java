package com.springcloud.rule;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Guo
 * @Date: 2020/9/15 11:40
 * 编写自定义轮训机制
 */
@Component
public class LB implements MyRuleBalance {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        // 需要返回和赋值给atomicInteger
        int next;
//         这里首先有一个原子类int型,初始值为0,这里用了一个自旋锁,让他判断每次是不是我们之前的那个值,
//         如果是就+1代表访问次数又增加一次,不是就继续循环直到判断为真跳出循环,
//         这里保证了不用synchronized方法也能在高并发下实现线程安全的增加次数
        do {
            current = atomicInteger.get();
            next = current >= 2147482647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问：next = " + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> list) {
        Integer current = getAndIncrement() % list.size();
        return list.get(current);
    }
}
