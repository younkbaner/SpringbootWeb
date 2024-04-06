package com.web.springbootweb.test;

import com.fasterxml.jackson.databind.node.ShortNode;

/**
 * @description:
 * @author: ywz
 * @time: 2024/4/6 12:23
 */
public class OddEvenPrinter {

   private volatile int count;

   private int limit;

   public OddEvenPrinter(int limit){
       this.limit = limit;
       count = 1;
   }

   public void oddPrinter(){
       synchronized (this){
           while (count<=limit){

               if (count % 2 == 0){
                   System.out.println("偶数打印器："+count);
                   count++;
                   notify();
               }else {
                   try {
                       wait();
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
           }
       }
   }

   public void eventPrinter()  {
       synchronized (this){
           while (count<=limit){
               if (count % 2 == 1){
                   System.out.println("---奇数打印器："+count);
                   count++;
                   notify();
               }else {
                   try {
                       wait();
                   }catch(Exception e){
                       e.printStackTrace();
                   }
               }
           }
       }
   }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(20);

        Thread oddThread = new Thread(printer::eventPrinter);

        Thread thread = new Thread(printer::oddPrinter);

        oddThread.start();

        thread.start();
    }
}
