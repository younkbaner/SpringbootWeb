package com.web.springbootweb.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: ywz
 * @time: 2023/9/25 23:31
 */
public class ArrayListTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list1 = new ArrayList(20);
        list1.add("三国演义");
        list1.add("水浒传");
        list1.add("西游记");
        list1.add("三国演义22");
        list1.add("水浒传2");
        list1.add("西游记2");
        list1.add("三国演义3");
        list1.add("水浒传3");
        list1.add("西游记3");
        list1.add("三国演义4");
        list1.add("水浒传4");
        list1.add("西游记4");

        List<String>synchronizedList=Collections.synchronizedList(list1);

        List<String>copyOnWriteList=new CopyOnWriteArrayList<>();






    }
}
