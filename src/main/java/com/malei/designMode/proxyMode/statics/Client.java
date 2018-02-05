package com.malei.designMode.proxyMode.statics;


/**
 * 客户端
 */
public class Client {

    public static void main(String[] args){
        /**
         * 通过代理去让外界使用
         * 代理对象可以传入不同的目标对象，这样去实现不同的接口方法
         * 例如： 传入生产鸡的目标对象，传入生产鸭的目标对象
         */
        ISubject subject = new Proxy(new RealSubject());
        subject.request();
    }
}
