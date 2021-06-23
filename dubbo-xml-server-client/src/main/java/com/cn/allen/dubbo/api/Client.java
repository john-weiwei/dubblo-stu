package com.cn.allen.dubbo.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.cn.allen.entity.OrderEntity;
import com.cn.allen.service.OrderService;

import java.lang.ref.Reference;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        ReferenceConfig<OrderService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(new ApplicationConfig("dubbo-client"));
        referenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        referenceConfig.setInterface(OrderService.class);

        OrderService orderService = referenceConfig.get();
        OrderEntity orderEntity = orderService.getDetail("1");
        System.out.println("earn:"+orderEntity.getMoney());
    }
}
