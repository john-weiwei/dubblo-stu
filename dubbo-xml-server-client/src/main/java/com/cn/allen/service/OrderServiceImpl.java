package com.cn.allen.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cn.allen.entity.OrderEntity;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
//此处要使用dubbo的注解，暴露服务
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderEntity getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId("O0001");
        orderEntity.setMoney(2000);
        orderEntity.setUserId("U0001");
        return orderEntity;
    }
}
