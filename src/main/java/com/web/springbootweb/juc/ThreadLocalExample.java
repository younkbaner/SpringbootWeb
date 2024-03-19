package com.web.springbootweb.juc;

import org.apache.catalina.core.ThreadLocalLeakPreventionListener;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/19 09:29
 */


/**
 * ThreadLocalExample类设置了一个 threadLocal 类型的 static final 变量
 *
 */
public class ThreadLocalExample  extends Thread{

    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();

        for (int i = 0;i<10;i++){
            Thread thread = new Thread(obj, " " + i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }


    //因为 formatter 是ThreadLocal 类型的成员变量，每个线程都有其自己的一份，其他线程修改后，不影响另外的线程使用
    //此处执行打印的结果是：每个线程都会打印出设置的时候的格式，即使被另外一个线程修改了，修改也是修改的线程独有的那一份。
    @Override
    public void run(){

        //打印线程原先的私有变量 yyyyMMdd HHmm
        System.out.println("Thread name   "+ Thread.currentThread().getName()+"default formatter  " + formatter.get().toPattern());

        //休眠，切换线程
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());
        //打印线程设置后的私有变量 yy-M-d ah:mm
        System.out.println("Thread name "+ Thread.currentThread().getName() + "formatter =  "+formatter.get().toPattern());

    }
}



