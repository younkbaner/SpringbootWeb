package com.web.springbootweb.collection;

import java.util.HashSet;

/**
 * @description:
 * @author: ywz
 * @time: 2023/10/2 10:10
 */
public class HashSetTest {

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("西游记");

        hashSet.add("水浒传");

        hashSet.add("三国演义");

        hashSet.add("红楼梦");

        hashSet.add(new String("testValue1"));
        hashSet.add(new String("testValue2"));

        System.out.println(hashSet);

        System.out.println(new String("hello").hashCode());


    }
}
