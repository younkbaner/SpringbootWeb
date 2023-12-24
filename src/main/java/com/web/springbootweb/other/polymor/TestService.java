package com.web.springbootweb.other.polymor;

/**
 * @description:
 * @author: ywz
 * @time: 2023/12/2 14:48
 */
public interface TestService {

   void abstractMethod();

   default void defaultMethod(){
       System.out.println("我是testService中的默认方法");
   }

   static void staticMethod(){
       System.out.println("我是testService中的静态方法");
   }
}
