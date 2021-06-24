package com.cn.allen.dao;

import com.cn.allen.entity.OrderEntity;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/24
 * @Description:
 */
@Service
public class OrderDaoImpl implements OrderDao {
    @Override
    public OrderEntity getDetail(String id) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId("O0001");
        orderEntity.setMoney(1000);
        orderEntity.setUserId("U0001");

        return orderEntity;
    }

    @Override
    public OrderEntity submit(OrderEntity order) {
        System.out.println("余额不足，请充值");
        order.setStatus(0);
        return order;
    }

    @Override
    public boolean cancel(OrderEntity order) {
        System.out.println("取消订单成功");
        order.setStatus(2);
        return true;
    }
}
