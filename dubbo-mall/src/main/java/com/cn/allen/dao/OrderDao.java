package com.cn.allen.dao;

import com.cn.allen.entity.OrderEntity;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/24
 * @Description:
 */
public interface OrderDao {
    OrderEntity getDetail(String id);
    OrderEntity submit(OrderEntity order);
    boolean cancel(OrderEntity order);
}
