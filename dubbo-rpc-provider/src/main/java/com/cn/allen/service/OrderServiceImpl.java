package com.cn.allen.service;

import com.cn.allen.entity.OrderEntity;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderEntity getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId("O0001");
        orderEntity.setMoney(1000);
        orderEntity.setUserId("U0001");
        return orderEntity;
    }
}
