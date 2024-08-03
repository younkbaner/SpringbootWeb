package com.web.springbootweb.leetcode;

/**
 * @description: 力扣 9：回文数
 * @author: ywz
 * @time: 2024/8/3 23:52
 */
public class PalindRome {

    public static void main(String[] args) {

        System.out.println(checkIsPalindRomeM1(1234));
        System.out.println(checkIsPalindRomeM2(1234));
        System.out.println(checkIsPalindRomeM3(1234));
        System.out.println();
        System.out.println(checkIsPalindRomeM1(123321));
        System.out.println(checkIsPalindRomeM2(123321));
        System.out.println(checkIsPalindRomeM3(123321));
    }


    /**
     * 反转字符串法，如果反转后的字符串和原字符串相同，则是回文数，否则不是
     */
    public static boolean checkIsPalindRomeM1(int i) {
        String num = Integer.toString(i);
        String reverseNum = new StringBuilder(num).reverse().toString();
        if (num.equals(reverseNum)) {
            return true;
        }
        return false;
    }

    /**
     * 数学方法：使用逐个获取目标字符串个位上的数，通过乘10再加上目标字符串上的个位数值，最后判断得到反转的数和目标数值是否相同
     */
    public static boolean checkIsPalindRomeM2(int i) {
        int num = i;
        int reverseNum = 0;
        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
        }
        if (i == reverseNum) {
            return true;
        }
        return false;
    }

    /**
     * 双指针法：先转换为字符串，再判断字符串首尾两个字符是否相同，如果不同直接返回 false，如果相同指针内移，直到指针碰头(left == right)
     */
    public static boolean checkIsPalindRomeM3(int i) {
        String num = String.valueOf(i);
        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
