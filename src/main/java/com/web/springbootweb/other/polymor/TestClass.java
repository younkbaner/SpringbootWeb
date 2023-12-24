package com.web.springbootweb.other.polymor;

/**
 * @description:
 * @author: ywz
 * @time: 2023/12/2 14:56
 */
public class TestClass {
    public static void main(String[] args) {


        TestService testService1 = new implements1();
        testService1.abstractMethod();
        testService1.defaultMethod();


        TestService testService2 = new implements2();
        testService2.abstractMethod();
        testService2.defaultMethod();


        TestService.staticMethod();

    }
}
