package com.cn.allen;

import com.alibaba.fastjson.JSON;
import com.cn.allen.service.InfoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.sampled.Line;
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
public class Consumer {

    @Configuration
    static class ConsumerConfiguration{
        @Bean
        public InfoService infoService() {
            InfoService infoService = null;
            try {
                //取远端服务实现
                infoService = (InfoService) Naming.lookup(InfoService.RMI_URL);
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return infoService;
        }
    }
    public static void main(String[] args) throws RemoteException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        InfoService infoService = (InfoService) ac.getBean("infoService");
        Object ret = infoService.sayHello("allen");
        System.out.println("测试远程调用功能infoService.sayHello，调用结果：" + JSON.toJSONString(ret));

        //呼叫远程反射方法
        Map<String,String> info = new HashMap();
        info.put("target","orderService");
        info.put("methodName","getDetail");
        info.put("arg","1");
        Object result = infoService.passInfo(info);
        System.out.println("测试远程调用功能，调用结果：" + JSON.toJSONString(result));
    }
}
