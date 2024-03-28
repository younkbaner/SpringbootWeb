package com.web.springbootweb.test;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

import java.math.BigDecimal;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/24 13:06
 */
public class FeetCaculate {


    public static void main(String[] args) {

        System.out.printf("My age is: %d and my height is: %.2f meters.fee is: %s", 90, 90.0,new BigDecimal("100.098").setScale(2,BigDecimal.ROUND_HALF_UP).toString());
        System.out.println();

        System.out.println(new BigDecimal("12.5").setScale(2, BigDecimal.ROUND_HALF_UP));

        BigDecimal amount = new BigDecimal("31036590");
        BigDecimal rate = getRate(amount);
        BigDecimal fee = amount.multiply(rate).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal roundedFee = getRoundedFee(fee);

        System.out.println("金额: " + amount);
        System.out.println("费率: " + rate);
        System.out.println("费用: " + fee);
        System.out.println("四舍五入后的费用: " + roundedFee);
    }

    // 根据金额范围得到费率
    public static BigDecimal getRate(BigDecimal amount) {

        if(amount.compareTo(new BigDecimal("50000"))<=0){
            return new BigDecimal("0.00008");
        }else if (amount.compareTo(new BigDecimal("2500000"))<=0){
            return new BigDecimal("0.00007");
        }else if (amount.compareTo(new BigDecimal("50000000"))<=0){
            return new BigDecimal("0.00006");
        }else {
            return new BigDecimal("0.00005");
        }
    }

    // 根据费率计算费用并进行四舍五入
    public static BigDecimal getRoundedFee(BigDecimal fee) {
        if (fee.compareTo(new BigDecimal("100"))<0){
            return new BigDecimal("100");
        }else if (fee.compareTo(new BigDecimal("10000"))>0){
            return new BigDecimal("10000");
        }else {
           return fee.setScale(2,BigDecimal.ROUND_HALF_UP);
        }

    }
}
