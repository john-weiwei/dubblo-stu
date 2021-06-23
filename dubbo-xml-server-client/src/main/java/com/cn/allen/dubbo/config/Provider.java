package com.cn.allen.dubbo.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
    @PropertySource("classpath:/dubbo-provider.properties")
    static class ProviderConfiguration {}
}
