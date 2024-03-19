package com.web.springbootweb.juc;

import lombok.Data;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/19 09:59
 */

/**
 * 测试 THreadLocal中存入多个值
 */

public class ThreadLocalExampleTest2 {

    static ValueStorage valueStorage = new ValueStorage();
    static ThreadLocal<ValueStorage> threadLocal = new ThreadLocal<ValueStorage>(){

        public ValueStorage initialValue(){
            return valueStorage;
        }
    };

    static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();




    public static void main(String[] args) {

        threadLocal2.set("test str");

        ValueStorage valueStorage1 = threadLocal.get();
        System.out.println(valueStorage1.getString1());
        System.out.println(valueStorage1.getString2());

        String s = threadLocal2.get();
        System.out.println(s);
    }
}


//如何在 ThreadLocal 中存放多个值


//方法一
@Data
class ValueStorage{

    private String string1 = "测试字符串 1";

    private String string2 = "测试字符串 2";
}


    //方法 er
    //声明两个 ThreadLocal 对象
    //ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    //ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
    //
    //public void yourMethod() {
    //    // 在当前线程中设置 stringThreadLocal 的值
    //    stringThreadLocal.set("Hello");
    //
    //    // 在当前线程中设置 integerThreadLocal 的值
    //    integerThreadLocal.set(123);
    //
    //    // 在当前线程中获取 stringThreadLocal 的值
    //    String stringValue = stringThreadLocal.get();
    //
    //    // 在当前线程中获取 integerThreadLocal 的值
    //    Integer integerValue = integerThreadLocal.get();
    //
    //    // 使用 stringThreadLocal 和 integerThreadLocal 的值进行操作
    //    // ...
    //
    //    // 清除当前线程中的 stringThreadLocal 和 integerThreadLocal 的值
    //    stringThreadLocal.remove();
    //    integerThreadLocal.remove();

