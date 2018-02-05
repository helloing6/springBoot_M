package com.malei.designMode.proxyMode.dynamic;

import com.malei.designMode.proxyMode.statics.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理对象
 */
public class JdkProxySubject implements InvocationHandler{

    private final RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(realSubject,args);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
