package com.web.springbootweb.controller;

import com.web.springbootweb.aop.MyAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ywz
 * @time: 2023/10/16 23:11
 */
@RestController
public class AopController {

    @RequestMapping("/helloAop")
    public String sayHello(){
        System.out.println("*********目标方法执行了***************");
        throw new RuntimeException();

    }


    @MyAnnotation(getName = "非默认名称",getAge = "非默认年龄")
    @RequestMapping("/helloAop2")
    public void sayHello2(){

        System.out.println("自定义方法执行***************");

    }
}
