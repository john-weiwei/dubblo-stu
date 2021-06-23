package com.cn.allen.action;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cn.allen.entity.OrderEntity;
import com.cn.allen.service.OrderService;
import org.springframework.stereotype.Component;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
@Component("annotatedConsumer")
public class ServiceConsumer {

    @Reference
    private OrderService orderService;

    public OrderEntity getDetail(String id) {
        return orderService.getDetail(id);
    }
}
