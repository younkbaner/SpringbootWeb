package com.web.springbootweb.collection;

import java.util.LinkedList;

/**
 * @description:
 * @author: ywz
 * @time: 2023/10/1 15:35
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("西游记");

        linkedList.add("水浒传");

        linkedList.add("三国演义");

        linkedList.add("红楼梦");

        linkedList.add("平凡的世界");

        linkedList.add("白鹿原");

        //System.out.println(linkedList.getFirst());
        //System.out.println(linkedList.getLast());
        //
        //boolean containsResult = linkedList.contains("西游记");
        //System.out.println("是否包含西游记:"+containsResult);
        //
        //int index = linkedList.indexOf("水浒传");
        //System.out.println("水浒传的次序在:"+index);
        //
        //String poll = linkedList.poll();
        //System.out.println(poll);
        //String pop = linkedList.pop();
        //System.out.println(pop);
        //
        //boolean offerResult = linkedList.offer("三国演义");
        //System.out.println("offer:"+offerResult);
        //
        //String peek = linkedList.peek();
        //System.out.println("peek:"+peek);

        String removeValue = linkedList.remove(1);
        System.out.println("删除的元素是:"+removeValue);

        String removeValue2 = linkedList.remove();
        System.out.println("删除的元素:"+ removeValue2);

        boolean removeValue3 = linkedList.remove("西游记");
        System.out.println("删除的元素:"+removeValue3);




    }
}
