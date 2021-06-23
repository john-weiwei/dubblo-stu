package com.cn.allen.dubbo.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.cn.allen.action.ServiceConsumer;
import com.cn.allen.entity.OrderEntity;
import com.cn.allen.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public class Consumer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        ac.start();
        System.out.println("服务消费方启动");
        ServiceConsumer serviceConsumer = (ServiceConsumer) ac.getBean("annotatedConsumer");
        OrderEntity orderEntity = serviceConsumer.getDetail("1");
        System.out.println("echo result: " + orderEntity.getMoney());
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.cn.allen.action")
    @PropertySource("classpath:/dubbo-consumer.properties")
    @ComponentScan(value = {"com.cn.allen.action"})
    static class ConsumerConfiguration{}
}
