package com.cn.allen.dubbo.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public class XmlServer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/dubbo-server.xml");
        xmlApplicationContext.start();
        System.out.println("服务提供方启动");
        //保持服务一直处于开启状态
        synchronized (XmlServer.class) {
            try {
                XmlServer.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
