package com.web.springbootweb.eneity;

/**
 * @description:
 * @author: ywz
 * @time: 2023/10/15 18:12
 */
public class SingleTonTest {

    //声明实例
    private static volatile SingleTonTest instance;

    //私有化构造器
    private SingleTonTest(){

    }

    public static synchronized SingleTonTest getInstance(){

        if (instance == null){
            synchronized (SingleTonTest.class){
                if (instance == null){
                    instance = new SingleTonTest();
                }
            }
        }

        return instance;
    }
}
