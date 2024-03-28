package com.web.springbootweb.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/24 09:00
 */
public class TestList {
    public static final int LISTLENGTH = 1000;
    public static final int VALIDLENGTH = 20;
    public static final int SLEEPTIME = 1;

    public static boolean isValidLength(String str) {
        if (str.length() < VALIDLENGTH) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //TODO Auto-generated method stub

        List<String> strList = new ArrayList<String>(LISTLENGTH);
        for (int i = 1; i <= LISTLENGTH; i++) {
            strList.add("[log]lineNumber:" + i);
        }
        int j = 0;
        while (j < strList.size()) {
            String str = strList.get(j);
            if (isValidLength(str)) {
                try {
                    System.out.println(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                j++;
            } else {
                try {
                    System.out.println(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            try {
                Thread.sleep(SLEEPTIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
