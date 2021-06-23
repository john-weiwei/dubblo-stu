package com.cn.allen.dubbo.annotation;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        ac.start();
        System.out.println("服务提供方启动");
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.cn.allen.service")
    static class ProviderConfiguration{

        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("dubbo-provider");
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

        @Bean
        public ProtocolConfig protocolConfig() {
            ProtocolConfig protocolConfig = new ProtocolConfig();
            protocolConfig.setName("dubbo");
            protocolConfig.setPort(20880);
            return protocolConfig;
        }
    }
}
