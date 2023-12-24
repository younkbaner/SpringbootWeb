package com.web.springbootweb.other.polymor;

/**
 * @description:
 * @author: ywz
 * @time: 2023/12/2 14:49
 */
public class implements1 implements TestService{

    @Override
    public void abstractMethod() {
        System.out.println("我是实现类1中的抽象方法实现");
    }
}
