package com.cn.allen;

import com.alibaba.fastjson.JSON;
import com.cn.allen.entity.OrderEntity;
import com.cn.allen.service.InfoService;
import com.cn.allen.service.InfoServiceImpl;
import com.cn.allen.service.OrderService;
import com.cn.allen.service.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public class Provider {

    @Configuration
    static class ProviderConfiguration {
        @Bean
        public OrderService orderService() {
            return new OrderServiceImpl();
        }
    }

    public static void main(String[] args) throws IOException, AlreadyBoundException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        applicationContext.start();
        System.out.println("spring启动.......");
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        OrderEntity orderEntity = orderService.getDetail("1");
        System.out.println("调用成功"+ JSON.toJSONString(orderEntity));


        System.out.println("-------------");
        Map<String,String> info = new HashMap();
        info.put("target","orderService");
        info.put("methodName","getDetail");
        info.put("arg","1");
        Object result = InvokeUtils.call(info,applicationContext);
        System.out.println("测试InvokeUtils.call调用功能，调用结果：" + JSON.toJSONString(result));

//        initProtocol1();
        initProtocol2(applicationContext);
        System.in.read();
    }

    //服务暴露
    public static void initProtocol1() {
        try {
            InfoService infoService = new InfoServiceImpl();
            //注册通讯端口
            LocateRegistry.createRegistry(InfoService.port);
            //注册通讯路径
            Naming.bind(InfoService.RMI_URL,infoService);
            System.out.println("初始化rmi绑定");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    public static void initProtocol2(ApplicationContext ac) throws RemoteException, AlreadyBoundException, MalformedURLException {
        InfoService infoService = new InfoServiceImpl(){
            @Override
            public Object passInfo(Map<String, String> info) throws RemoteException {
                super.passInfo(info);
                Object ret = InvokeUtils.call(info,ac);
                System.out.println("测试InvokeUtils.call调用功能，调用结果：" + JSON.toJSONString(ret));
                return ret;
            }
        };
        //注册通讯端口
        LocateRegistry.createRegistry(InfoService.port);
        //注册通讯路径
        Naming.bind(InfoService.RMI_URL,infoService);
        System.out.println("初始化rmi绑定");
    }
}
