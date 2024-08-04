package com.web.springbootweb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 力扣 13 罗马数字转数值
 */
public class RomanToInt {

    private static final Map<Character, Integer> reflectionMap = new HashMap<>();

    static {
        reflectionMap.put('I', 1);
        reflectionMap.put('V', 5);
        reflectionMap.put('X', 10);
        reflectionMap.put('L', 50);
        reflectionMap.put('C', 100);
        reflectionMap.put('D', 500);
        reflectionMap.put('M', 1000);
    }

    public static void main(String[] args) {
        String inoutRoman = new StringBuilder("MCMLXXXVII").toString();
        System.out.println(romanNumToInt(inoutRoman));


    }

    private static int romanNumToInt(String romanNum) {
        int intNum = 0;
        int romanNumLength = romanNum.length();
        for (int i = 0; i < romanNumLength; i++) {
            int currentValue = transFor(romanNum.charAt(i));
            //罗马数字的两个规则
            //加法规则：如果一个较大的数字在一个较小数字的前面，则他们相加
            //减法规则：如果一个较大的数字在一个较小数字的后面，则他们想减
            if (i == romanNumLength - 1 || transFor(romanNum.charAt(i + 1)) <= currentValue) {
                intNum += currentValue;
            } else {
                intNum -= currentValue;
            }
        }
        return intNum;
    }

    private static int transFor(char x) {
        return reflectionMap.get(x);
    }
}
