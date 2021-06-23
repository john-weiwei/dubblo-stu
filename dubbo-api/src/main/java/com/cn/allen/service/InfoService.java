package com.cn.allen.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public interface InfoService extends Remote {
    String RMI_URL = "rmi://127.0.0.1:9080/InfoService";
    int port = 9080;
    Object sayHello(String name) throws RemoteException;
    Object passInfo(Map<String,String> info) throws RemoteException;
}
