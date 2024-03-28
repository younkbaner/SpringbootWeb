package com.web.springbootweb.utils;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/28 14:33
 */
public class TikaUtils {


    public static void main(String[] args) throws TikaException, IOException {
        File file = new File("/Users/mac/IdeaProjects/SpringbootWeb/src/main/resources/data.txt");

        Tika tika = new Tika();

        String s = tika.parseToString(file);

        System.out.println(s);

    }
}


