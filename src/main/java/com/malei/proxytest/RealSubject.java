package com.malei.proxytest;

/**
 * 目标对象
 */
public class RealSubject implements ISubject{
    /**
     * 真正的去处理工作
     */
    @Override
    public void request() {
        System.out.println("我开始干活了");
    }
}
