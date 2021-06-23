package com.cn.allen.utils;

import com.alibaba.fastjson.JSON;
import com.cn.allen.entity.OrderEntity;
import com.cn.allen.service.InfoService;
import com.cn.allen.service.OrderService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public class RmiClient {
    public static void main(String[] args) {
        InfoService infoService = null;
        try {
            //获取远程服务实现
            infoService = (InfoService) Naming.lookup(InfoService.RMI_URL);
            Object ret = infoService.sayHello("allen");
            System.out.println("测试远程调用功能infoService.sayHello，调用结果：" + JSON.toJSONString(ret));

            //呼叫远程反射方法
            Map<String,String> info = new HashMap();
            info.put("target","orderService");
            info.put("methodName","getDetail");
            info.put("arg","1");
            Object result = infoService.passInfo(info);
            System.out.println("测试远程调用功能，调用结果：" + JSON.toJSONString(result));

            //静态代理方法
            OrderService service = getService(infoService);
            Object result2 = service.getDetail("1");//透明化调用，不增加开发人员的负担
            System.out.println("测试远程调用功能，调用结果：" + JSON.toJSONString(result2));

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 静态代理，动态编译类来实现
     * @param infoService
     * @return
     */
    public static OrderService getService(InfoService infoService) {
        OrderService orderService = id -> {
            Map<String,String> info = new HashMap<>();
            //写死了反射的目标，静态代理
            info.put("target","orderService");//对象
            info.put("methodName","getDetail");//方法
            info.put("arg",id);//参数
            OrderEntity result = null;
            try {
                result = (OrderEntity) infoService.passInfo(info);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return result;
        };
        return orderService;
    }
}
