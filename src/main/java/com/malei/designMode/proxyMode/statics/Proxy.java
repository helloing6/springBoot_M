package com.malei.designMode.proxyMode.statics;

/**
 * 代理对象
 */
public class Proxy implements ISubject {

    private final RealSubject realSubject;

    /**
     * 代理对构造函数需要传入目标对象
     * @param realSubject
     */
    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject ;
    }

    /**
     * 委托 目标对象 去执行
     */
    @Override
    public void request() {
        realSubject.request();
    }
}
