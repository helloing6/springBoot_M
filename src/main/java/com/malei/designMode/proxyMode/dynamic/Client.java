package com.malei.designMode.proxyMode.dynamic;

import com.malei.designMode.proxyMode.statics.ISubject;
import com.malei.designMode.proxyMode.statics.RealSubject;

import javax.security.auth.Subject;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args){

        ISubject subject = (ISubject)Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{ISubject.class},
                new JdkProxySubject(new RealSubject()));
        subject.request();

    }
}
