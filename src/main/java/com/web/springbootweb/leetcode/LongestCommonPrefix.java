package com.web.springbootweb.leetcode;

/**
 * @description: 查找字符串数组中的最长公共前缀
 * @author: ywz
 * @time: 2024/8/4 15:00
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "ow", "flight"};
        System.out.println(getLongestCommonPrefix(strs));
    }

    private static String getLongestCommonPrefix(String[] strs) {
        int min = 201;
        //寻找最短字符串
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }

        //寻找最短公共字串
        StringBuilder stringBuilder = new StringBuilder();

        //只需要比较最短字符串的长度即可
        for (int i = 0; i < min; i++) {
            char cur = strs[0].charAt(i);

            //字符串数组中的每一位是否和要比较的目标字符相等，如果相等就比较下一位，如果不等就返回已经得到的公共字符字串
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != cur)
                    return stringBuilder.toString();
            }
            stringBuilder.append(cur);
        }
        return stringBuilder.toString();
    }
}
