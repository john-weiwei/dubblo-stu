package com.cn.allen.dubbo.annotation;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.cn.allen.action.ServiceConsumer;
import com.cn.allen.entity.OrderEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
    @ComponentScan(value = {"com.cn.allen.action"})
    static class ConsumerConfiguration{
        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("dubbo-consumer");
            return applicationConfig;
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("127.0.0.1");
            registryConfig.setPort(2181);
            registryConfig.setProtocol("zookeeper");
            return registryConfig;
        }
    }
}
