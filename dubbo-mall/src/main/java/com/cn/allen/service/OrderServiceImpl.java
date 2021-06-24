package com.cn.allen.service;

import com.cn.allen.dao.OrderDao;
import com.cn.allen.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

//@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductService productService;


    @Override
    public OrderEntity getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+ System.currentTimeMillis());
        OrderEntity orderEntity =  orderDao.getDetail(id);
        orderEntity.addProduct(productService.getDetail("P001"));
//        orderEntity.addProduct(productService.getDetail("P002"));


        return orderEntity;
    }
}
