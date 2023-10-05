package com.web.springbootweb.collection;

import java.util.Vector;

/**
 * @description:
 * @author: ywz
 * @time: 2023/10/1 14:53
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(5);

        for (int i=0;i<9;i++){

            vector.add("西游记"+i);
        }

        vector.remove(7);

        System.out.println(vector);
    }
}
