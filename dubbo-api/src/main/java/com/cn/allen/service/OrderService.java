package com.cn.allen.service;

import com.cn.allen.entity.OrderEntity;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public interface OrderService {
    OrderEntity getDetail(String id);
}
