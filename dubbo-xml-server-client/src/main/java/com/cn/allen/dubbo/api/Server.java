package com.cn.allen.dubbo.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.cn.allen.service.OrderService;
import com.cn.allen.service.OrderServiceImpl;

import java.io.IOException;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServiceConfig<OrderService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(new ApplicationConfig("dubbo-server"));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.setInterface(OrderService.class);
        serviceConfig.setRef(new OrderServiceImpl());
        serviceConfig.export();
        System.out.println("first-dubbo-provider is running.");
        System.in.read();
    }
}
