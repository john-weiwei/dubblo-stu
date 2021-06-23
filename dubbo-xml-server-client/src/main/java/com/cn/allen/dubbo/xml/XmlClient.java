package com.cn.allen.dubbo.xml;

import com.cn.allen.entity.OrderEntity;
import com.cn.allen.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public class XmlClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/dubbo-client.xml");
        xmlApplicationContext.start();
        System.out.println("服务消费方启动");
        OrderService orderService = (OrderService) xmlApplicationContext.getBean("orderService");
        OrderEntity orderEntity = orderService.getDetail("1");
        System.out.println("echo result: " + orderEntity.getMoney());
    }
}
