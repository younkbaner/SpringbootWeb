package com.web.springbootweb.other.annotationtest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/28 17:01
 */
@Aspect
@Component
public class PrintBeforeExecutionAspect {

    @Before("@annotation(PrintBeforeExecution)")
    public void printBeforeExecution() {
        System.out.println("注解生效，下面开始执行方法");
    }
}

