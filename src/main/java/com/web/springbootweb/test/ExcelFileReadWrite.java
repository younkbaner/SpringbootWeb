package com.web.springbootweb.test;

import com.alibaba.excel.annotation.ExcelProperty;

import com.web.springbootweb.eneity.Student;
import com.web.springbootweb.utils.ExcelUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

/**
 * @description:
 * @author: ywz
 * @time: 2024/4/11 15:29
 */
@Slf4j
public class ExcelFileReadWrite {


    public static void main(String[] args) {

        File file = new File("/Users/mac/IdeaProjects/SpringbootWeb/src/main/resources/TestExcel.xlsx");
        List<Student> students = ExcelUtils.readData(file, Student.class);
        log.info("文件读取完毕");
        for (Student student : students) {
            System.out.println("student:--->" + student);
        }


    }
}



