package com.web.springbootweb.other.proxylearn;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/28 10:32
 */
public class ProxyTest {

    public static void main(String[] args) {

        //创建被代理类
        Dog dog = new Dog();

        //获取代理类
        ProxyFactory proxyFactory = ProxyFactory.getInstance();

        System.out.println("***************使用Cglib动态代理*********************");
        //测试使用cglib动态代理

        //获取被代理类的代理类
        Dog dogProxyFromCglib =(Dog) proxyFactory.getCglibProxy(dog);
        //使用代理类去执行方法
        dogProxyFromCglib.say();

        System.out.println("***************使用jdk动态代理*********************");

        Object jdkProxy = proxyFactory.getJdkProxy(dog);


    }
}
