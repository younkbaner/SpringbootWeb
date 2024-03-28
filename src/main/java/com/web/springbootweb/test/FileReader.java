package com.web.springbootweb.test;

import java.io.*;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/27 11:12
 */
public class FileReader {


    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader("/Users/mac/IdeaProjects/SpringbootWeb/src/main/resources/data.txt"));

        String line;
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }

    }
}
