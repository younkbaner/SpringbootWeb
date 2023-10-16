package com.web.springbootweb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: ywz
 * @time: 2023/10/16 23:12
 */
@Aspect
@Component
public class AopAdvice {

    @Pointcut("execution (* com.web.springbootweb.controller.*.*(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeAdvice() {
        System.out.println("beforeAdvice...");
    }

    @After("test()")
    public void afterAdvice() {
        System.out.println("afterAdvice...");
    }



    @Around("test()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知-目标方法执行之前执行的");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("环绕通知-目标方法执行之后执行的");
    }

    @AfterThrowing("test()")
    public void afterThrowingAdvice(){
        System.out.println("目标方法抛出了异常");
    }

}
