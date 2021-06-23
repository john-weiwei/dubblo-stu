package com.cn.allen;

import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
public class InvokeUtils {

    /**
     * java 反射调用
     * @param target
     * @param methodName
     * @param argTypes
     * @param args
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Object call(Object target,String methodName,
                              Class[] argTypes,Object[] args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = target.getClass().getMethod(methodName, argTypes);
        return method.invoke(target,args);
    }

    public static Object call(Map<String,String> info, ApplicationContext ac) {
        String targetStr = info.get("target");
        String methodName = info.get("methodName");
        String arg = info.get("arg");
        try {
            return call(ac.getBean(targetStr),methodName,new Class[]{String.class},new Object[]{arg});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
