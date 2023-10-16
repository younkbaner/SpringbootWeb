package com.web.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //告诉SpringBoot 这是一个SpringBoot程序
public class SpringbootWebApplication {

    public static void main(String[] args) {
        //定义一个主类
        SpringApplication.run(SpringbootWebApplication.class, args);
    }

}
