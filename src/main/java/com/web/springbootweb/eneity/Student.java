package com.web.springbootweb.eneity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @description:
 * @author: ywz
 * @time: 2024/4/11 15:36
 */
@Data
public class Student {

    @ExcelProperty("姓名")
    String name;

    @ExcelProperty("性别")
    String sex;

    @ExcelProperty("手机号")
    String phone;
}
