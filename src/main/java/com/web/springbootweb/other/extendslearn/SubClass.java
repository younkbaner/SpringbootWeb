package com.web.springbootweb.other.extendslearn;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/26 12:45
 */
@Component
public class SubClass{


    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("通过注解指定bean实例化时指定的方法");
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println("通过注解指定bean销毁时执行的方法");
    }
}
