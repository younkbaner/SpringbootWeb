package com.web.springbootweb.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/18 14:47
 */
public class HashMapIteratorTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //第一种遍历方式 EntrySet 的方式进行遍历
        //Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        //while (iterator.hasNext()){
        //    Map.Entry<Integer, String> entry = iterator.next();
        //    System.out.println(entry.getKey()+"---"+entry.getValue());
        //}

        //第二种方式 KeySet 的方式进行遍历
        //Iterator<Integer> iterator = map.keySet().iterator();
        //while (iterator.hasNext()){
        //    Integer key = iterator.next();
        //    System.out.println(key+"---"+map.get(key));
        //}

        //第三种方式
        //Set<Map.Entry<Integer, String>> entries = map.entrySet();
        //for ( Map.Entry<Integer, String> entry: map.entrySet()){
        //    System.out.println(entry.getKey()+"---"+entry.getValue());
        //}

        //第四种方式
        //for (Integer key : map.keySet()){
        //    System.out.println(key+"---"+map.get(key));
        //}

        //第五种方式
        //map.forEach((key,value)->{
        //    System.out.println(key+"---"+value);
        //});


        //第六种
        //map.entrySet().stream().forEach((entry)->{
        //    System.out.println(entry.getKey()+"---"+entry.getValue());
        //});

        map.entrySet().parallelStream().forEach((entry)->{
            System.out.println(entry.getKey()+"---"+entry.getValue());
        });

    }
}
